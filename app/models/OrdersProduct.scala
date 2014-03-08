package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current
import java.math.{BigDecimal}


case class OrdersProduct(id: Int, qty: Int, priceBuy: BigDecimal, productID: Int, ordersID: Int)

object OrdersProduct {
  val ordersProduct = {
    get[Int]("id") ~
    get[Int]("qty") ~
    get[BigDecimal]("priceBuy") ~
    get[Int]("productID") ~
    get[Int]("ordersID") map {
      case id~qty~priceBuy~productID~ordersID => OrdersProduct(id, qty, priceBuy, productID, ordersID)
    }
  }

  def getMonthlySalesPerProduct(id: Int): List[OrdersProduct] = DB.withConnection { implicit c =>
    SQL("select * from ordersProducts op " +
      "inner join orders o on op.ordersID = o.id " +
      "where op.productID = {id} " +
      "order by o.createdAt desc").on('id -> id).as(ordersProduct *)
  }

  def getMonthlySalesPerCategory(id: Int): List[OrdersProduct] = DB.withConnection { implicit c =>
    SQL("select * from ordersProducts op " +
      "inner join orders o on op.ordersID = o.id " +
      "inner join products p on op.productID = p.id " +
      "inner join category c on p.categoryID = {id} " +
      "order by o.createdAt desc").on('id -> id).as(ordersProduct *)
  }

  /*def create(qty: Int, priceBuy: BigDecimal) {
    // TODO: We'll probably need to get FOREIGN KEY values for customerID and ordersID
    DB.withConnection { implicit c =>
      SQL("insert into ordersProducts(qty, priceBuy, catProductID, ordersID) values ({qty, priceBuy, catProductID, ordersID})").on(
        'qty -> qty,
        'priceBuy -> priceBuy,
        'catProductID -> catProductID,
        'ordersID -> ordersID
      ).executeInsert()
    }
  }*/
}
