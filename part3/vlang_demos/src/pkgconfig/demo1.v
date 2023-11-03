$if $pkgconfig('mysqlclient') {
	#pkgconfig mysqlclient
} $else $if $pkgconfig('mariadb') {
	#pkgconfig mariadb
}
