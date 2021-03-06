(ns structured-data)

(defn do-a-thing [x]
  (let [xx (+ x x)]
    (Math/pow xx xx)))

(defn spiff [v]
  (let [x (get v 0)
        y (get v 2)]
    (+ x y)))

(defn cutify [v]
  (conj v "<3"))

(defn spiff-destructuring [[a, b, c]]
  (+ a c))

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn testing [v1 v2]
  (let [[vx1 vy1] v1]))

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- x2 x1)))

(defn height [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- y2 y1)))

(defn square? [rectangle]
  (if (== (width rectangle)
          (height rectangle))
    true
    false))

(defn area [rectangle]
  (* (width rectangle)
     (height rectangle)))

(defn contains-point? [rectangle point]
  (let [[[rx1 ry1] [rx2 ry2]] rectangle
        [px py] point]
    (if (and (<= rx1 px rx2)
             (<= ry1 py ry2))
      true
      false)))

;; Exercise 9
(defn contains-rectangle? [outer inner]
  (let [[[ox1 oy1] [ox2 oy2]] outer
        [[ix1 iy1] [ix2 iy2]] inner]
    (if (and (<= ox1 ix1 ix2 ox2)
             (<= oy1 iy1 iy2 oy2))
      true
      false)))

;; Exercise 10
(defn title-length [book]
  (count (:title book)))

;; Exercise 11
(defn author-count [book]
  (count (:authors book)))

;; Exercise 12
(defn multiple-authors? [book]
  (<= 2 (author-count book)))

;; Exercise 13
(defn add-author [book new-author]
  (let [authors (:authors book)]
    (assoc book :authors (conj authors new-author))))

;; Exercise 14
(defn alive? [author]
  (not (contains? author :death-year)))

;; Exercise 15
(defn element-lengths [collection]
  (map count collection))

;; Exercise 16
(defn second-elements [collection]
  (let [snd (fn [x] (get x 1))]
    (map snd collection)))

;; Exercise 17
(defn titles [books]
  (map :title books))

;; Exercise 18
(defn stars [n]
  (apply str (repeat n "*")))

;; Exercise 19
(defn monotonic? [a-seq]
  (or (apply <= a-seq)
      (apply >= a-seq)))

;; Exercise 20
(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

;; Exercise 21
(defn contains-duplicates? [a-seq]
  (if (== (count a-seq)
          (count (set a-seq)))
    false
    true))

;; Exercise 22
(defn old-book->new-book [book]
  (let [a-set (:authors book)]
    (assoc book :authors (set a-set))))

;; Exercise 23
(defn has-author? [book author]
  (let [authors (:authors book)]
    (contains? authors author)))

;; Exercise 24
(defn authors [books]
  (apply clojure.set/union
         (map :authors books)))

;; Exercise 25
(defn all-author-names [books]
  (clojure.set/union (set (map :name (authors books)))))

;; Exercise 26
(defn author->string [author]
  (let [name (:name author)
        birth (:birth-year author)
        death (:death-year author)
        bdstr (if birth
                (str " (" birth " - " death ")")
                nil)]
    (str name bdstr)))

;; Exercise 27
(defn authors->string [authors]
  (let [author-names (apply map [author->string authors])]
    (apply str (interpose ", " author-names))))

(defn book->string [book]
  :-)

(defn books->string [books]
  :-)

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%
