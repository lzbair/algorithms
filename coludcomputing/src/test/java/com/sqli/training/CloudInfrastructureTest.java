package com.sqli.training;

import org.junit.Assert;
import org.junit.Test;

public class CloudInfrastructureTest {


    CloudInfrastructure cloud = new CloudInfrastructure();

    @Test
    public void create_store() {
        cloud.createStore("myFiles");
        cloud.uploadDocument("book.pdf");
        Assert.assertEquals("myFiles:book.pdf", cloud.listStores());
    }

    @Test
    public void create_multiple_stores() {
        cloud.createStore("myFiles");
        cloud.createStore("myImages");
        cloud.uploadDocument("myImages", "picture.jpeg", "profile.png");
        Assert.assertEquals("myFiles:empty||myImages:picture.jpeg, profile.png", cloud.listStores());
    }

    @Test
    public void delete_or_empty_stores() {
        cloud.createStore("myFiles");
        cloud.createStore("myImages");
        cloud.uploadDocument("myImages", "picture.jpeg", "profile.png");
        cloud.deleteStore("myFiles");
        cloud.emptyStore("myFiles");
        Assert.assertEquals("myImages:empty", cloud.listStores());
    }

    @Test(expected = CreateStoreException.class)
    public void cannot_create_stores_with_same_names() {
        cloud.createStore("myFiles");
        cloud.createStore("myFiles");
    }

    @Test(expected = UploadDocumentException.class)
    public void should_specify_store_to_use_when_multiple() {
        cloud.createStore("myFiles");
        cloud.createStore("myImages");
        cloud.uploadDocument("book.pdf"); // You have to specify the store to be used
    }

    @Test
    public void create_machines() {
        cloud.createMachine("machine1", "Linux", "50gb", "8gb");
        cloud.createMachine("machine2", "Windows", "20gb", "4gb");
        Assert.assertEquals("machine1:Inactive||machine2:Inactive", cloud.listMachines());

        cloud.startMachine("machine1");
        Assert.assertEquals("machine1:running||machine2:Inactive", cloud.listMachines());

        cloud.startMachine("machine2");
        cloud.stopMachine("machine1");
        Assert.assertEquals("machine1:stopped||machine2:running", cloud.listMachines());
    }

    @Test(expected = MachineStateException.class)
    public void cannot_launch_already_started_machine() {
        cloud.createMachine("machine1", "Linux", "50gb", "8gb");
        cloud.startMachine("machine1");
        Assert.assertEquals("machine1:running", cloud.listMachines());
        cloud.startMachine("machine1");
    }

    @Test(expected = ModuleNotFoundException.class)
    public void no_module_is_installed_yet_on_machine() {
        cloud.createMachine("machine1", "Linux", "50gb", "8gb");
        cloud.startMachine("machine1");
        Assert.assertEquals("machine1:empty", cloud.installedModules());
        cloud.console("machine1", "java --version");
    }

    @Test
    public void install_modules_on_machine() {
        cloud.createMachine("machine1", "Ubuntu", "50gb", "8gb");
        cloud.startMachine("machine1");
        cloud.console("machine1", "apt install -y vim");


        Assert.assertEquals("machine1:vim", cloud.installedModules());
        Assert.assertEquals("VIM version: LATEST", cloud.console("machine1", "vim --version"));
    }



   }
