package main

import "fmt"

//Go提供了另一个重要的数据类型，称为map，它将唯一键映射到值。
//键是一个对象，您可以在以后使用它来检索值。
//给定键和值，您可以将值存储在Map对象中。
//值存储后，可以使用其键检索它

// 定义方式：
///* declare a variable, by default map will be nil*/
//var map_variable map[key_data_type]value_data_type
//
///* define the map as nil map can not be assigned any value*/
//map_variable = make(map[key_data_type]value_data_type)

func main() {
	var countryCapitalMap map[string]string
	/* create a map*/
	//您必须使用make函数来创建
	countryCapitalMap = make(map[string]string)

	/* insert key-value pairs in the map*/
	countryCapitalMap["France"] = "Paris"
	countryCapitalMap["Italy"] = "Rome"
	countryCapitalMap["Japan"] = "Tokyo"
	countryCapitalMap["India"] = "New Delhi"

	/* print map using keys*/
	for country := range countryCapitalMap {
		fmt.Println("Capital of", country, "is", countryCapitalMap[country])
	}

	/* test if entry is present in the map or not*/
	capital, ok := countryCapitalMap["United States"]

	/* if ok is true, entry is present otherwise entry is absent*/
	if ok {
		fmt.Println("Capital of United States is", capital)
	} else {
		fmt.Println("Capital of United States is not present")
	}
}
