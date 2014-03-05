package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class ShippingNotice(id: Int, companyID: Int)

object ShippingNotice {
  val shippingNotice = {
    get[Int]("id") ~
    get[Int]("companyID") map {
      case id~companyID => ShippingNotice(id, companyID)
    }
  }
}
