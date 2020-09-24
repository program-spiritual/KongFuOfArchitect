(setq lst (list '(1 2) '(3 4) '(5 6)))
(setq mylst (copy-list lst))
(setq tr (copy-tree lst))

(write lst)
(terpri)
(write mylst)
(terpri)
(write tr)