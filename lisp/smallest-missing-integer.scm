; (93 18 56 101 17 16)  -->  15
; (10 -89 99 -1 0) --> -90

(define (SMI lst s) (cond ((null? lst) s)
                           (else (SMI (cdr lst) (min (- (car lst) 1)  s)))
))

