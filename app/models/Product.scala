package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Product(id: Int, stockNumber: String, companyID: Int, modelID: Int, categoryID: Int, description: String)

object Product {
  val product = {
    get[Int]("id") ~
    get[String]("stockNumber") ~
    get[Int]("companyID") ~
    get[Int]("modelID") ~
    get[Int]("categoryID") ~
    get[String]("description") map {
      case id~stockNumber~companyID~modelID~categoryID~description => Product(id, stockNumber, companyID, modelID, categoryID, description)
    }
  }

  def all(): List[Product] = DB.withConnection { implicit c =>
    SQL("select * from product").as(product *)
  }

  /*def create(stockNumber: String) {
    // TODO: We'll probably need to get a FOREIGN KEY value for productID, companyID, modelID, and categoryID
    DB.withConnection { implicit c =>
      SQL("insert into catalogProducts(stockNumber) values ({stockNumber})").on(
        'stockNumber -> stockNumber
      ).executeInsert()
    }
  }*/
}
