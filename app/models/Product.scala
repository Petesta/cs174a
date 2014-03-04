package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Product(id: Int, stockNumber: String, modelID: Int, companyID: Int)

object Product {
  val product = {
    get[Int]("id") ~
    get[String]("stockNumber") ~
    get[Int]("modelID") ~
    get[Int]("companyID") map {
      case id~stockNumber~modelID~companyID => Product(id, stockNumber, modelID, companyID)
    }
  }

  def create(stockNumber: String) {
    // TODO: We'll probably need to get a FOREIGN KEY value for modelID and companyID
    DB.withConnection { implicit c =>
      SQL("insert into products(stockNumber) values ({stockNumber})").on(
        'stockNumber -> stockNumber
      ).executeInsert()
    }
  }
}
