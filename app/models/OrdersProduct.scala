package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current

case class OrdersProduct(id: Int, qty: Int, priceBuy: BigDecimal, catProductID: Int, ordersID: Int)

object OrdersProduct {
  val ordersProduct = {
    get[Int]("id") ~
    get[Int]("qty") ~
    get[BigDecimal]("priceBuy") ~
    get[Int]("catProductID") ~
    get[Int]("ordersID") map {
      case id~qty~priceBuy~catProductID~ordersID => OrdersProduct(id, qty, priceBuy, catProductID, ordersID)
    }
  }

  def create(qty: Int, priceBuy: BigDecimal) {
    // TODO: We'll probably need to get FOREIGN KEY values for customerID and ordersID
    DB.withConnection { implicit c =>
      SQL("insert into ordersProducts(qty, priceBuy, catProductID, ordersID) values ({qty, priceBuy, catProductID, ordersID})").on(
        'qty -> qty,
        'priceBuy -> priceBuy,
        'catProductID -> catProductID,
        'ordersID -> ordersID
      ).executeInsert()
    }
  }
}
