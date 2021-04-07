1. 
(list 2 3 5 7 11 13 17)

2. 
(define (listeclavier)
	(let ( (c (read)))
		(if (equal? c "fin") '()
			(cons c (listeclavier))))
	)

3. 
(define (listeNum)
	(let ( (c (read)))
		(if (equal? c 0) '()
			(cons c (listeNum))))
	)

4. 
(define (LN)
	(listeNum)
	)

5. 
(define (nombreL L)
	(if (null? L) 0
		(+ (nombreL (cdr L)) 1 ))
	)

> (nombreL (list 1 2 3))
> (nombreL '(1 2 3))

6. 
(define (maxL L)
	(if (null? (cdr L)) (car L)
		(if (> (car L) (maxL (cdr L))) (car L) 
			(maxL (cdr L)
				)
			)
		)
	)


Mathieu

(define (uniqueL? L) (if (null? (cdr L)) #t (if (null? (cdr (cdr L))) (not (= (car L) (car (cdr L)))) (and (not (= (car L) (car (cdr L)))) (uniqueL? (cdr L))))))
( define (nombreL L) ( if (null? L) 0
                            (+ (nombreL (cdr L)) 1))) 
(define (mapAux a b) (if (null? a) '() (cons ( cons (car a) (car b)) (mapAux (cdr a) (cdr b)))))
(define (map2 a b) (if (and (= (nombreL a) (nombreL b)) ( uniqueL? a)) (mapAux a b) "Problème de tailles incompatibles ou de liste non-unique"))
(define (M) (map2 (key) (name)))





EX3 SUITE 

(define (map2 a b)
    (if(null? a) '()
    (cons (cons (car a) (car b)) (map2 (cdr a) (cdr b))))
)

> (define mymap (map2 '(prenom nom) '(albert poireau)))
> mymap
((prenom . albert) (nom . poireau))


(define (mapping a b)
    (if (and (= nb_elements a) (nb_elements b)) (unique? a)) (map2 a b)
    "mapping impossible"
)

(list ( cons prenom Mathieu ) ( cons nom DosSantos ))

(define mymap 
	(list ( cons "prenom" "Mathieu" ) 
		( cons "nom" "DosSantos" ))
	)

5. 
(define (min_key l)
	(if (= (nb_elements l) 1)
		(car l)
		(if (<(caar l)(car(min_key(cdr l))))
			(car l)
			(min_key (cdr l)))
		)
	)


(define l '(1, 2, 3))
> (car l)
1
> (cdr l)
(2 3)
> (cddr l)
(3)
> (car (cdr l))
2
> (cadr l)
2

(define mylist '( (a1 a2)             
                  (b1 b2)
                  (c1 c2)
                  (d1 d2) ) )
> (car mylist)
(a1 a2)
> (caar mylist)
a1
> (cddr mylist)
((c1 c2) (d1 d2))
> (cdar mylist)
(a2)
> (caadr mylist)
b1
> (cdadr mylist)
(b2)


6. 
(define (priv_map c m)
	(cond((null? m)
		m)
		((equal? (car m) c) 
			(cdr m))
		(else (cons (car m) (priv_map c (cdr m))))
		)
	)


8. 
(define l1 '(1 2 3 4))
(define l2 (1 . ((2 . ((3. ((4. () ) )))))))




















