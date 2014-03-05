package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class ShippingProduct(id: Int, stockNumber: Int, qty: Int, shippingNoticeID: Int)

object ShippingProduct {
  val shippingProduct = {
    get[Int]("id") ~
    get[Int]("stockNumber") ~
    get[Int]("qty") ~
    get[Int]("shippingNoticeID") map {
      case id~stockNumber~qty~shippingNoticeID => ShippingProduct(id, stockNumber, qty, shippingNoticeID)
    }
  }
}
