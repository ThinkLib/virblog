package controllers

import controllers.Actions._
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object I18n extends Controller {

  def zhs2Zht = AuthenticatedAsyncAction(BodyParsers.parse.json) { request =>
    var zht = Utils.zhs2Zht((request.body \ "content").as[String])
    zht = zht.replace('“', '「')
    zht = zht.replace('”', '」')
    zht = zht.replace('‘', '『')
    zht = zht.replace('’', '』')
    Future(Ok(zht))
  }

}
