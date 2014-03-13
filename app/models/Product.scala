package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current


case class Product(id: Int, stockNumber: String, price: Double, companyID: Int, modelID: Int, categoryID: Int, description: String)

object Product {
  val product = {
    get[Int]("id") ~
    get[String]("stockNumber") ~
    get[Double]("price") ~
    get[Int]("companyID") ~
    get[Int]("modelID") ~
    get[Int]("categoryID") ~
    get[String]("description") map {
      case id~stockNumber~price~companyID~modelID~categoryID~description => Product(id, stockNumber, price, companyID, modelID, categoryID, description)
    }
  }

  def all(): List[Product] = DB.withConnection { implicit c =>
    SQL("select * from products").as(product *)
  }

  def getById(id: Int): List[Product] = DB.withConnection { implicit c =>
    SQL("select * from products where id = {id} LIMIT 1").on('id -> id).as(product *)
  }

  def searchByKeyValue(key: String, value: String): List[Product] = DB.withConnection { implicit c =>
    SQL("select * from products where {key} = {value}").on('key -> key, 'value -> value).as(product *)
  }

  def update(price: Double) {
    DB.withConnection { implicit c =>
      SQL("update products set price={price}").on(
        'price -> price
      ).executeUpdate()
    }
  }

}
