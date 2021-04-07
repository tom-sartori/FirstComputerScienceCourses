(define (A n)
	(do 
		( 
			(i 0 (+ i 1))
			(m 0. (+ m (read)))
		)
		(
			(= i n) (/ m n)
		)

	)
)

(define (M L)
	(map(lambda(x)(* x x))L))

(define E(list 1 2 3))
> (M E)
(1 4 9)