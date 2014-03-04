package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class CatalogProduct(id: Int, stockNumber: String, productID: Int, companyID: Int, modelID: Int, categoryID: Int)

object CatalogProduct {
  val catalogProduct = {
    get[Int]("id") ~
    get[String]("stockNumber") ~
    get[Int]("productID") ~
    get[Int]("companyID") ~
    get[Int]("modelID") ~
    get[Int]("categoryID") map {
      case id~stockNumber~productID~companyID~modelID~categoryID => CatalogProduct(id, stockNumber, productID, companyID, modelID, categoryID)
    }
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
