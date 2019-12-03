package main

import "fmt"

//Range expression	1st Value	2nd Value(Optional)
//Array or slice a [n]E	index i int	a[i] E
//String s string type	index i int	rune int
//map m map[K]V	key k K	value m[k] V
//channel c chan E	element e E	none
func main() {
	/* create a slice */
	numbers := []int{0, 1, 2, 3, 4, 5, 6, 7, 8}

	/* print the numbers */
	for i := range numbers {
		fmt.Println("Slice item", i, "is", numbers[i])
	}

	/* create a map*/
	countryCapitalMap := map[string]string{"France": "Paris", "Italy": "Rome", "Japan": "Tokyo"}

	/* print map using keys*/
	for country := range countryCapitalMap {
		fmt.Println("Capital of", country, "is", countryCapitalMap[country])
	}

	/* print map using key-value*/
	for country, capital := range countryCapitalMap {
		fmt.Println("Capital of", country, "is", capital)
	}
}
