package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.{API, CreativeAttribute}

case class Native(request: String, ver: Option[String], api: Option[Seq[API]], battr: Option[Seq[CreativeAttribute]],
                  ext: Option[Any])