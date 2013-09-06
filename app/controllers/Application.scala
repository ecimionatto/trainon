package controllers

import play.api.mvc.Action
import play.api.mvc.Controller
import java.util.UUID
import java.net.URLEncoder

object Application extends Controller {

  def index = Action { request =>

    val authtoken = request.getQueryString("authtoken")
    if (authtoken.isEmpty) {

      val code = UUID.randomUUID().toString();
      Redirect(" https://accounts.google.com/o/oauth2/auth?response_type=code&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&redirect_uri=" + URLEncoder.encode("http://localhost:9000/oauth2callback", "UTF-8") + "&client_id=826826734667.apps.googleusercontent.com");

    } else if (!verifyToken(authtoken)) {
      Unauthorized
    } else {
      Ok(views.html.index("Your new application is ready."))
    }

  }

  def oauth2callback = Action { request =>

    val code = request.getQueryString("code");
    if (code.isEmpty) {
      Unauthorized(views.html.index("Authorization fail."))
    } else {
      Ok(views.html.index("Authorization successful."))
    }

  }

  def verifyToken(authtoken: Option[String]): Boolean = {
    return false;
  }

}