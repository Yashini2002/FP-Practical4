object InventoryManagement{
    def displayInventory(itemNames: Array[String], itemQuantities: Array[Int]): Unit ={
        if(itemNames.length != itemQuantities.length){
            println("Error: The lengths of item names and item quantities do not match.")
            return
        }

        println("------------------------Inventory-------------------------")
        for(i <- itemNames.indices){
            println(s"${itemNames(i)}: ${itemQuantities(i)}")
        }
    }

    def restockItem(itemNames: Array[String], itemQuantities: Array[Int], item: String, quantity: Int): Unit = {
        val index = itemNames.indexOf(item)
        if(index != -1){
            itemQuantities(index) += quantity
            println(s"\n\n$quantity units of $item added to the stock.")
        } else{
            println(s"Item '$item' does not exist in the inventory.")
        }
    }

    def sellItem(itemNames: Array[String], itemQuantities: Array[Int], item: String, quantity: Int): Unit = {
        val index = itemNames.indexOf(item)
        if(index != -1){
            if(itemQuantities(index) >= quantity){
                itemQuantities(index) -= quantity
                println(s"\n\n$quantity units of $item sold.")
            }
            else{
                println(s"Not enough stock of $item to sell $quantity units.")
            }
        }
        else{
            println(s"Item '$item' does not exist in the inventory.")
        }
    }


    def main(args: Array[String]): Unit ={
        val itemNames = Array("Apple", "Mango", "Orange", "Banana", "Grapes")
        val itemQuantities= Array(10, 12, 5, 20, 8)

        displayInventory(itemNames, itemQuantities)

        //restocking items
        restockItem(itemNames, itemQuantities, "Apple", 3)
        restockItem(itemNames, itemQuantities, "Watermelon", 2)

        displayInventory(itemNames, itemQuantities)

        //selling items
        sellItem(itemNames, itemQuantities, "Mango", 3)
        sellItem(itemNames, itemQuantities, "Grapes", 10)

        displayInventory(itemNames, itemQuantities)

    }
}