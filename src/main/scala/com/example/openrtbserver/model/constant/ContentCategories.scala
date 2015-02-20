package com.example.openrtbserver.model.constant

trait ContentCategory extends Constant {
  final type Value = String
}

object ContentCategories extends Constants[ContentCategory] {

  val values: List[ContentCategory] =
    List(`IAB1`, `IAB1-1`, `IAB1-2`, `IAB1-3`, `IAB1-4`, `IAB1-5`, `IAB1-6`, `IAB1-7`, `IAB2`, `IAB2-1`,
      `IAB2-2`, `IAB2-3`, `IAB2-4`, `IAB2-5`, `IAB2-6`, `IAB2-7`, `IAB2-8`, `IAB2-9`, `IAB2-10`, `IAB2-11`, `IAB2-12`,
      `IAB2-13`, `IAB2-14`, `IAB2-15`, `IAB2-16`, `IAB2-17`, `IAB2-18`, `IAB2-19`, `IAB2-20`, `IAB2-21`, `IAB2-22`,
      `IAB2-23`, `IAB3`, `IAB3-1`, `IAB3-2`, `IAB3-3`, `IAB3-4`, `IAB3-5`, `IAB3-6`, `IAB3-7`, `IAB3-8`, `IAB3-9`,
      `IAB3-10`, `IAB3-11`, `IAB3-12`, `IAB4`, `IAB4-1`, `IAB4-2`, `IAB4-3`, `IAB4-4`, `IAB4-5`, `IAB4-6`, `IAB4-7`,
      `IAB4-8`, `IAB4-9`, `IAB4-10`, `IAB4-11`, `IAB5`, `IAB5-1`, `IAB5-2`, `IAB5-3`, `IAB5-4`, `IAB5-5`, `IAB5-6`,
      `IAB5-7`, `IAB5-8`, `IAB5-9`, `IAB5-10`, `IAB5-11`, `IAB5-12`, `IAB5-13`, `IAB5-14`, `IAB5-15`, `IAB6`, `IAB6-1`,
      `IAB6-2`, `IAB6-3`, `IAB6-4`, `IAB6-5`, `IAB6-6`, `IAB6-7`, `IAB6-8`, `IAB6-9`, `IAB7`, `IAB7-1`, `IAB7-2`,
      `IAB7-3`, `IAB7-4`, `IAB7-5`, `IAB7-6`, `IAB7-7`, `IAB7-8`, `IAB7-9`, `IAB7-10`, `IAB7-11`, `IAB7-12`, `IAB7-13`,
      `IAB7-14`, `IAB7-15`, `IAB7-16`, `IAB7-17`, `IAB7-18`, `IAB7-19`, `IAB7-20`, `IAB7-21`, `IAB7-22`, `IAB7-23`,
      `IAB7-24`, `IAB7-25`, `IAB7-26`, `IAB7-27`, `IAB7-28`, `IAB7-29`, `IAB7-30`, `IAB7-31`, `IAB7-32`, `IAB7-33`,
      `IAB7-34`, `IAB7-35`, `IAB7-36`, `IAB7-37`, `IAB7-38`, `IAB7-39`, `IAB7-40`, `IAB7-41`, `IAB7-42`, `IAB7-43`,
      `IAB7-44`, `IAB7-45`, `IAB8`, `IAB8-1`, `IAB8-2`, `IAB8-3`, `IAB8-4`, `IAB8-5`, `IAB8-6`, `IAB8-7`, `IAB8-8`,
      `IAB8-9`, `IAB8-10`, `IAB8-11`, `IAB8-12`, `IAB8-13`, `IAB8-14`, `IAB8-15`, `IAB8-16`, `IAB8-17`, `IAB8-18`,
      `IAB9`, `IAB9-1`, `IAB9-2`, `IAB9-3`, `IAB9-4`, `IAB9-5`, `IAB9-6`, `IAB9-7`, `IAB9-8`, `IAB9-9`, `IAB9-10`,
      `IAB9-11`, `IAB9-12`, `IAB9-13`, `IAB9-14`, `IAB9-15`, `IAB9-16`, `IAB9-17`, `IAB9-18`, `IAB9-19`, `IAB9-20`,
      `IAB9-21`, `IAB9-22`, `IAB9-23`, `IAB9-24`, `IAB9-25`, `IAB9-26`, `IAB9-27`, `IAB9-28`, `IAB9-29`, `IAB9-30`,
      `IAB9-31`, `IAB10`, `IAB10-1`, `IAB10-2`, `IAB10-3`, `IAB10-4`, `IAB10-5`, `IAB10-6`, `IAB10-7`, `IAB10-8`,
      `IAB10-9`, `IAB11`, `IAB11-1`, `IAB11-2`, `IAB11-3`, `IAB11-4`, `IAB11-5`, `IAB12`, `IAB12-1`, `IAB12-2`, `IAB12-3`,
      `IAB13`, `IAB13-1`, `IAB13-2`, `IAB13-3`, `IAB13-4`, `IAB13-5`, `IAB13-6`, `IAB13-7`, `IAB13-8`, `IAB13-9`,
      `IAB13-10`, `IAB13-11`, `IAB13-12`, `IAB14`, `IAB14-1`, `IAB14-2`, `IAB14-3`, `IAB14-4`, `IAB14-5`, `IAB14-6`,
      `IAB14-7`, `IAB14-8`, `IAB15`, `IAB15-1`, `IAB15-2`, `IAB15-3`, `IAB15-4`, `IAB15-5`, `IAB15-6`, `IAB15-7`,
      `IAB15-8`, `IAB15-9`, `IAB15-10`, `IAB16`, `IAB16-1`, `IAB16-2`, `IAB16-3`, `IAB16-4`, `IAB16-5`, `IAB16-6`,
      `IAB16-7`, `IAB17`, `IAB17-1`, `IAB17-2`, `IAB17-3`, `IAB17-4`, `IAB17-5`, `IAB17-6`, `IAB17-7`, `IAB17-8`,
      `IAB17-9`, `IAB17-10`, `IAB17-11`, `IAB17-12`, `IAB17-13`, `IAB17-14`, `IAB17-15`, `IAB17-16`, `IAB17-17`,
      `IAB17-18`, `IAB17-19`, `IAB17-20`, `IAB17-21`, `IAB17-22`, `IAB17-23`, `IAB17-24`, `IAB17-25`, `IAB17-26`,
      `IAB17-27`, `IAB17-28`, `IAB17-29`, `IAB17-30`, `IAB17-31`, `IAB17-32`, `IAB17-33`, `IAB17-34`, `IAB17-35`,
      `IAB17-36`, `IAB17-37`, `IAB17-38`, `IAB17-39`, `IAB17-40`, `IAB17-41`, `IAB17-42`, `IAB17-43`, `IAB17-44`,
      `IAB18`, `IAB18-1`, `IAB18-2`, `IAB18-3`, `IAB18-4`, `IAB18-5`, `IAB18-6`, `IAB19`, `IAB19-1`, `IAB19-2`, `IAB19-3`,
      `IAB19-4`, `IAB19-5`, `IAB19-6`, `IAB19-7`, `IAB19-8`, `IAB19-9`, `IAB19-10`, `IAB19-11`, `IAB19-12`, `IAB19-13`,
      `IAB19-14`, `IAB19-15`, `IAB19-16`, `IAB19-17`, `IAB19-18`, `IAB19-19`, `IAB19-20`, `IAB19-21`, `IAB19-22`,
      `IAB19-23`, `IAB19-24`, `IAB19-25`, `IAB19-26`, `IAB19-27`, `IAB19-28`, `IAB19-29`, `IAB19-30`, `IAB19-31`,
      `IAB19-32`, `IAB19-33`, `IAB19-34`, `IAB19-35`, `IAB19-36`, `IAB20`, `IAB20-1`, `IAB20-2`, `IAB20-3`,
      `IAB20-4`, `IAB20-5`, `IAB20-6`, `IAB20-7`, `IAB20-8`, `IAB20-9`, `IAB20-10`, `IAB20-11`, `IAB20-12`,
      `IAB20-13`, `IAB20-14`, `IAB20-15`, `IAB20-16`, `IAB20-17`, `IAB20-18`, `IAB20-19`, `IAB20-20`, `IAB20-21`,
      `IAB20-22`, `IAB20-23`, `IAB20-24`, `IAB20-25`, `IAB20-26`, `IAB20-27`, `IAB21`, `IAB21-1`, `IAB21-2`, `IAB21-3`,
      `IAB22`, `IAB22-1`, `IAB22-2`, `IAB22-3`, `IAB22-4`, `IAB23`, `IAB23-1`, `IAB23-2`, `IAB23-3`, `IAB23-4`, `IAB23-5`,
      `IAB23-6`, `IAB23-7`, `IAB23-8`, `IAB23-9`, `IAB23-10`, `IAB24`, `IAB25`, `IAB25-1`, `IAB25-2`, `IAB25-3`,
      `IAB25-4`, `IAB25-5`, `IAB25-6`, `IAB25-7`, `IAB26`, `IAB26-1`, `IAB26-2`, `IAB26-3`, `IAB26-4`)

  case object `IAB1` extends ContentCategory {
    def value: String = "IAB1"
  }

  case object `IAB1-1` extends ContentCategory {
    def value: String = "IAB1-1"
  }

  case object `IAB1-2` extends ContentCategory {
    def value: String = "IAB1-2"
  }

  case object `IAB1-3` extends ContentCategory {
    def value: String = "IAB1-3"
  }

  case object `IAB1-4` extends ContentCategory {
    def value: String = "IAB1-4"
  }

  case object `IAB1-5` extends ContentCategory {
    def value: String = "IAB1-5"
  }

  case object `IAB1-6` extends ContentCategory {
    def value: String = "IAB1-6"
  }

  case object `IAB1-7` extends ContentCategory {
    def value: String = "IAB1-7"
  }

  case object `IAB2` extends ContentCategory {
    def value: String = "IAB2"
  }

  case object `IAB2-1` extends ContentCategory {
    def value: String = "IAB2-1"
  }

  case object `IAB2-2` extends ContentCategory {
    def value: String = "IAB2-2"
  }

  case object `IAB2-3` extends ContentCategory {
    def value: String = "IAB2-3"
  }

  case object `IAB2-4` extends ContentCategory {
    def value: String = "IAB2-4"
  }

  case object `IAB2-5` extends ContentCategory {
    def value: String = "IAB2-5"
  }

  case object `IAB2-6` extends ContentCategory {
    def value: String = "IAB2-6"
  }

  case object `IAB2-7` extends ContentCategory {
    def value: String = "IAB2-7"
  }

  case object `IAB2-8` extends ContentCategory {
    def value: String = "IAB2-8"
  }

  case object `IAB2-9` extends ContentCategory {
    def value: String = "IAB2-9"
  }

  case object `IAB2-10` extends ContentCategory {
    def value: String = "IAB2-10"
  }

  case object `IAB2-11` extends ContentCategory {
    def value: String = "IAB2-11"
  }

  case object `IAB2-12` extends ContentCategory {
    def value: String = "IAB2-12"
  }

  case object `IAB2-13` extends ContentCategory {
    def value: String = "IAB2-13"
  }

  case object `IAB2-14` extends ContentCategory {
    def value: String = "IAB2-14"
  }

  case object `IAB2-15` extends ContentCategory {
    def value: String = "IAB2-15"
  }

  case object `IAB2-16` extends ContentCategory {
    def value: String = "IAB2-16"
  }

  case object `IAB2-17` extends ContentCategory {
    def value: String = "IAB2-17"
  }

  case object `IAB2-18` extends ContentCategory {
    def value: String = "IAB2-18"
  }

  case object `IAB2-19` extends ContentCategory {
    def value: String = "IAB2-19"
  }

  case object `IAB2-20` extends ContentCategory {
    def value: String = "IAB2-20"
  }

  case object `IAB2-21` extends ContentCategory {
    def value: String = "IAB2-21"
  }

  case object `IAB2-22` extends ContentCategory {
    def value: String = "IAB2-22"
  }

  case object `IAB2-23` extends ContentCategory {
    def value: String = "IAB2-23"
  }

  case object `IAB3` extends ContentCategory {
    def value: String = "IAB3"
  }

  case object `IAB3-1` extends ContentCategory {
    def value: String = "IAB3-1"
  }

  case object `IAB3-2` extends ContentCategory {
    def value: String = "IAB3-2"
  }

  case object `IAB3-3` extends ContentCategory {
    def value: String = "IAB3-3"
  }

  case object `IAB3-4` extends ContentCategory {
    def value: String = "IAB3-4"
  }

  case object `IAB3-5` extends ContentCategory {
    def value: String = "IAB3-5"
  }

  case object `IAB3-6` extends ContentCategory {
    def value: String = "IAB3-6"
  }

  case object `IAB3-7` extends ContentCategory {
    def value: String = "IAB3-7"
  }

  case object `IAB3-8` extends ContentCategory {
    def value: String = "IAB3-8"
  }

  case object `IAB3-9` extends ContentCategory {
    def value: String = "IAB3-9"
  }

  case object `IAB3-10` extends ContentCategory {
    def value: String = "IAB3-10"
  }

  case object `IAB3-11` extends ContentCategory {
    def value: String = "IAB3-11"
  }

  case object `IAB3-12` extends ContentCategory {
    def value: String = "IAB3-12"
  }

  case object `IAB4` extends ContentCategory {
    def value: String = "IAB4"
  }

  case object `IAB4-1` extends ContentCategory {
    def value: String = "IAB4-1"
  }

  case object `IAB4-2` extends ContentCategory {
    def value: String = "IAB4-2"
  }

  case object `IAB4-3` extends ContentCategory {
    def value: String = "IAB4-3"
  }

  case object `IAB4-4` extends ContentCategory {
    def value: String = "IAB4-4"
  }

  case object `IAB4-5` extends ContentCategory {
    def value: String = "IAB4-5"
  }

  case object `IAB4-6` extends ContentCategory {
    def value: String = "IAB4-6"
  }

  case object `IAB4-7` extends ContentCategory {
    def value: String = "IAB4-7"
  }

  case object `IAB4-8` extends ContentCategory {
    def value: String = "IAB4-8"
  }

  case object `IAB4-9` extends ContentCategory {
    def value: String = "IAB4-9"
  }

  case object `IAB4-10` extends ContentCategory {
    def value: String = "IAB4-10"
  }

  case object `IAB4-11` extends ContentCategory {
    def value: String = "IAB4-11"
  }

  case object `IAB5` extends ContentCategory {
    def value: String = "IAB5"
  }

  case object `IAB5-1` extends ContentCategory {
    def value: String = "IAB5-1"
  }

  case object `IAB5-2` extends ContentCategory {
    def value: String = "IAB5-2"
  }

  case object `IAB5-3` extends ContentCategory {
    def value: String = "IAB5-3"
  }

  case object `IAB5-4` extends ContentCategory {
    def value: String = "IAB5-4"
  }

  case object `IAB5-5` extends ContentCategory {
    def value: String = "IAB5-5"
  }

  case object `IAB5-6` extends ContentCategory {
    def value: String = "IAB5-6"
  }

  case object `IAB5-7` extends ContentCategory {
    def value: String = "IAB5-7"
  }

  case object `IAB5-8` extends ContentCategory {
    def value: String = "IAB5-8"
  }

  case object `IAB5-9` extends ContentCategory {
    def value: String = "IAB5-9"
  }

  case object `IAB5-10` extends ContentCategory {
    def value: String = "IAB5-10"
  }

  case object `IAB5-11` extends ContentCategory {
    def value: String = "IAB5-11"
  }

  case object `IAB5-12` extends ContentCategory {
    def value: String = "IAB5-12"
  }

  case object `IAB5-13` extends ContentCategory {
    def value: String = "IAB5-13"
  }

  case object `IAB5-14` extends ContentCategory {
    def value: String = "IAB5-14"
  }

  case object `IAB5-15` extends ContentCategory {
    def value: String = "IAB5-15"
  }

  case object `IAB6` extends ContentCategory {
    def value: String = "IAB6"
  }

  case object `IAB6-1` extends ContentCategory {
    def value: String = "IAB6-1"
  }

  case object `IAB6-2` extends ContentCategory {
    def value: String = "IAB6-2"
  }

  case object `IAB6-3` extends ContentCategory {
    def value: String = "IAB6-3"
  }

  case object `IAB6-4` extends ContentCategory {
    def value: String = "IAB6-4"
  }

  case object `IAB6-5` extends ContentCategory {
    def value: String = "IAB6-5"
  }

  case object `IAB6-6` extends ContentCategory {
    def value: String = "IAB6-6"
  }

  case object `IAB6-7` extends ContentCategory {
    def value: String = "IAB6-7"
  }

  case object `IAB6-8` extends ContentCategory {
    def value: String = "IAB6-8"
  }

  case object `IAB6-9` extends ContentCategory {
    def value: String = "IAB6-9"
  }

  case object `IAB7` extends ContentCategory {
    def value: String = "IAB7"
  }

  case object `IAB7-1` extends ContentCategory {
    def value: String = "IAB7-1"
  }

  case object `IAB7-2` extends ContentCategory {
    def value: String = "IAB7-2"
  }

  case object `IAB7-3` extends ContentCategory {
    def value: String = "IAB7-3"
  }

  case object `IAB7-4` extends ContentCategory {
    def value: String = "IAB7-4"
  }

  case object `IAB7-5` extends ContentCategory {
    def value: String = "IAB7-5"
  }

  case object `IAB7-6` extends ContentCategory {
    def value: String = "IAB7-6"
  }

  case object `IAB7-7` extends ContentCategory {
    def value: String = "IAB7-7"
  }

  case object `IAB7-8` extends ContentCategory {
    def value: String = "IAB7-8"
  }

  case object `IAB7-9` extends ContentCategory {
    def value: String = "IAB7-9"
  }

  case object `IAB7-10` extends ContentCategory {
    def value: String = "IAB7-10"
  }

  case object `IAB7-11` extends ContentCategory {
    def value: String = "IAB7-11"
  }

  case object `IAB7-12` extends ContentCategory {
    def value: String = "IAB7-12"
  }

  case object `IAB7-13` extends ContentCategory {
    def value: String = "IAB7-13"
  }

  case object `IAB7-14` extends ContentCategory {
    def value: String = "IAB7-14"
  }

  case object `IAB7-15` extends ContentCategory {
    def value: String = "IAB7-15"
  }

  case object `IAB7-16` extends ContentCategory {
    def value: String = "IAB7-16"
  }

  case object `IAB7-17` extends ContentCategory {
    def value: String = "IAB7-17"
  }

  case object `IAB7-18` extends ContentCategory {
    def value: String = "IAB7-18"
  }

  case object `IAB7-19` extends ContentCategory {
    def value: String = "IAB7-19"
  }

  case object `IAB7-20` extends ContentCategory {
    def value: String = "IAB7-20"
  }

  case object `IAB7-21` extends ContentCategory {
    def value: String = "IAB7-21"
  }

  case object `IAB7-22` extends ContentCategory {
    def value: String = "IAB7-22"
  }

  case object `IAB7-23` extends ContentCategory {
    def value: String = "IAB7-23"
  }

  case object `IAB7-24` extends ContentCategory {
    def value: String = "IAB7-24"
  }

  case object `IAB7-25` extends ContentCategory {
    def value: String = "IAB7-25"
  }

  case object `IAB7-26` extends ContentCategory {
    def value: String = "IAB7-26"
  }

  case object `IAB7-27` extends ContentCategory {
    def value: String = "IAB7-27"
  }

  case object `IAB7-28` extends ContentCategory {
    def value: String = "IAB7-28"
  }

  case object `IAB7-29` extends ContentCategory {
    def value: String = "IAB7-29"
  }

  case object `IAB7-30` extends ContentCategory {
    def value: String = "IAB7-30"
  }

  case object `IAB7-31` extends ContentCategory {
    def value: String = "IAB7-31"
  }

  case object `IAB7-32` extends ContentCategory {
    def value: String = "IAB7-32"
  }

  case object `IAB7-33` extends ContentCategory {
    def value: String = "IAB7-33"
  }

  case object `IAB7-34` extends ContentCategory {
    def value: String = "IAB7-34"
  }

  case object `IAB7-35` extends ContentCategory {
    def value: String = "IAB7-35"
  }

  case object `IAB7-36` extends ContentCategory {
    def value: String = "IAB7-36"
  }

  case object `IAB7-37` extends ContentCategory {
    def value: String = "IAB7-37"
  }

  case object `IAB7-38` extends ContentCategory {
    def value: String = "IAB7-38"
  }

  case object `IAB7-39` extends ContentCategory {
    def value: String = "IAB7-39"
  }

  case object `IAB7-40` extends ContentCategory {
    def value: String = "IAB7-40"
  }

  case object `IAB7-41` extends ContentCategory {
    def value: String = "IAB7-41"
  }

  case object `IAB7-42` extends ContentCategory {
    def value: String = "IAB7-42"
  }

  case object `IAB7-43` extends ContentCategory {
    def value: String = "IAB7-43"
  }

  case object `IAB7-44` extends ContentCategory {
    def value: String = "IAB7-44"
  }

  case object `IAB7-45` extends ContentCategory {
    def value: String = "IAB7-45"
  }

  case object `IAB8` extends ContentCategory {
    def value: String = "IAB8"
  }

  case object `IAB8-1` extends ContentCategory {
    def value: String = "IAB8-1"
  }

  case object `IAB8-2` extends ContentCategory {
    def value: String = "IAB8-2"
  }

  case object `IAB8-3` extends ContentCategory {
    def value: String = "IAB8-3"
  }

  case object `IAB8-4` extends ContentCategory {
    def value: String = "IAB8-4"
  }

  case object `IAB8-5` extends ContentCategory {
    def value: String = "IAB8-5"
  }

  case object `IAB8-6` extends ContentCategory {
    def value: String = "IAB8-6"
  }

  case object `IAB8-7` extends ContentCategory {
    def value: String = "IAB8-7"
  }

  case object `IAB8-8` extends ContentCategory {
    def value: String = "IAB8-8"
  }

  case object `IAB8-9` extends ContentCategory {
    def value: String = "IAB8-9"
  }

  case object `IAB8-10` extends ContentCategory {
    def value: String = "IAB8-10"
  }

  case object `IAB8-11` extends ContentCategory {
    def value: String = "IAB8-11"
  }

  case object `IAB8-12` extends ContentCategory {
    def value: String = "IAB8-12"
  }

  case object `IAB8-13` extends ContentCategory {
    def value: String = "IAB8-13"
  }

  case object `IAB8-14` extends ContentCategory {
    def value: String = "IAB8-14"
  }

  case object `IAB8-15` extends ContentCategory {
    def value: String = "IAB8-15"
  }

  case object `IAB8-16` extends ContentCategory {
    def value: String = "IAB8-16"
  }

  case object `IAB8-17` extends ContentCategory {
    def value: String = "IAB8-17"
  }

  case object `IAB8-18` extends ContentCategory {
    def value: String = "IAB8-18"
  }

  case object `IAB9` extends ContentCategory {
    def value: String = "IAB9"
  }

  case object `IAB9-1` extends ContentCategory {
    def value: String = "IAB9-1"
  }

  case object `IAB9-2` extends ContentCategory {
    def value: String = "IAB9-2"
  }

  case object `IAB9-3` extends ContentCategory {
    def value: String = "IAB9-3"
  }

  case object `IAB9-4` extends ContentCategory {
    def value: String = "IAB9-4"
  }

  case object `IAB9-5` extends ContentCategory {
    def value: String = "IAB9-5"
  }

  case object `IAB9-6` extends ContentCategory {
    def value: String = "IAB9-6"
  }

  case object `IAB9-7` extends ContentCategory {
    def value: String = "IAB9-7"
  }

  case object `IAB9-8` extends ContentCategory {
    def value: String = "IAB9-8"
  }

  case object `IAB9-9` extends ContentCategory {
    def value: String = "IAB9-9"
  }

  case object `IAB9-10` extends ContentCategory {
    def value: String = "IAB9-10"
  }

  case object `IAB9-11` extends ContentCategory {
    def value: String = "IAB9-11"
  }

  case object `IAB9-12` extends ContentCategory {
    def value: String = "IAB9-12"
  }

  case object `IAB9-13` extends ContentCategory {
    def value: String = "IAB9-13"
  }

  case object `IAB9-14` extends ContentCategory {
    def value: String = "IAB9-14"
  }

  case object `IAB9-15` extends ContentCategory {
    def value: String = "IAB9-15"
  }

  case object `IAB9-16` extends ContentCategory {
    def value: String = "IAB9-16"
  }

  case object `IAB9-17` extends ContentCategory {
    def value: String = "IAB9-17"
  }

  case object `IAB9-18` extends ContentCategory {
    def value: String = "IAB9-18"
  }

  case object `IAB9-19` extends ContentCategory {
    def value: String = "IAB9-19"
  }

  case object `IAB9-20` extends ContentCategory {
    def value: String = "IAB9-20"
  }

  case object `IAB9-21` extends ContentCategory {
    def value: String = "IAB9-21"
  }

  case object `IAB9-22` extends ContentCategory {
    def value: String = "IAB9-22"
  }

  case object `IAB9-23` extends ContentCategory {
    def value: String = "IAB9-23"
  }

  case object `IAB9-24` extends ContentCategory {
    def value: String = "IAB9-24"
  }

  case object `IAB9-25` extends ContentCategory {
    def value: String = "IAB9-25"
  }

  case object `IAB9-26` extends ContentCategory {
    def value: String = "IAB9-26"
  }

  case object `IAB9-27` extends ContentCategory {
    def value: String = "IAB9-27"
  }

  case object `IAB9-28` extends ContentCategory {
    def value: String = "IAB9-28"
  }

  case object `IAB9-29` extends ContentCategory {
    def value: String = "IAB9-29"
  }

  case object `IAB9-30` extends ContentCategory {
    def value: String = "IAB9-30"
  }

  case object `IAB9-31` extends ContentCategory {
    def value: String = "IAB9-31"
  }

  case object `IAB10` extends ContentCategory {
    def value: String = "IAB10"
  }

  case object `IAB10-1` extends ContentCategory {
    def value: String = "IAB10-1"
  }

  case object `IAB10-2` extends ContentCategory {
    def value: String = "IAB10-2"
  }

  case object `IAB10-3` extends ContentCategory {
    def value: String = "IAB10-3"
  }

  case object `IAB10-4` extends ContentCategory {
    def value: String = "IAB10-4"
  }

  case object `IAB10-5` extends ContentCategory {
    def value: String = "IAB10-5"
  }

  case object `IAB10-6` extends ContentCategory {
    def value: String = "IAB10-6"
  }

  case object `IAB10-7` extends ContentCategory {
    def value: String = "IAB10-7"
  }

  case object `IAB10-8` extends ContentCategory {
    def value: String = "IAB10-8"
  }

  case object `IAB10-9` extends ContentCategory {
    def value: String = "IAB10-9"
  }

  case object `IAB11` extends ContentCategory {
    def value: String = "IAB11"
  }

  case object `IAB11-1` extends ContentCategory {
    def value: String = "IAB11-1"
  }

  case object `IAB11-2` extends ContentCategory {
    def value: String = "IAB11-2"
  }

  case object `IAB11-3` extends ContentCategory {
    def value: String = "IAB11-3"
  }

  case object `IAB11-4` extends ContentCategory {
    def value: String = "IAB11-4"
  }

  case object `IAB11-5` extends ContentCategory {
    def value: String = "IAB11-5"
  }

  case object `IAB12` extends ContentCategory {
    def value: String = "IAB12"
  }

  case object `IAB12-1` extends ContentCategory {
    def value: String = "IAB12-1"
  }

  case object `IAB12-2` extends ContentCategory {
    def value: String = "IAB12-2"
  }

  case object `IAB12-3` extends ContentCategory {
    def value: String = "IAB12-3"
  }

  case object `IAB13` extends ContentCategory {
    def value: String = "IAB13"
  }

  case object `IAB13-1` extends ContentCategory {
    def value: String = "IAB13-1"
  }

  case object `IAB13-2` extends ContentCategory {
    def value: String = "IAB13-2"
  }

  case object `IAB13-3` extends ContentCategory {
    def value: String = "IAB13-3"
  }

  case object `IAB13-4` extends ContentCategory {
    def value: String = "IAB13-4"
  }

  case object `IAB13-5` extends ContentCategory {
    def value: String = "IAB13-5"
  }

  case object `IAB13-6` extends ContentCategory {
    def value: String = "IAB13-6"
  }

  case object `IAB13-7` extends ContentCategory {
    def value: String = "IAB13-7"
  }

  case object `IAB13-8` extends ContentCategory {
    def value: String = "IAB13-8"
  }

  case object `IAB13-9` extends ContentCategory {
    def value: String = "IAB13-9"
  }

  case object `IAB13-10` extends ContentCategory {
    def value: String = "IAB13-10"
  }

  case object `IAB13-11` extends ContentCategory {
    def value: String = "IAB13-11"
  }

  case object `IAB13-12` extends ContentCategory {
    def value: String = "IAB13-12"
  }

  case object `IAB14` extends ContentCategory {
    def value: String = "IAB14"
  }

  case object `IAB14-1` extends ContentCategory {
    def value: String = "IAB14-1"
  }

  case object `IAB14-2` extends ContentCategory {
    def value: String = "IAB14-2"
  }

  case object `IAB14-3` extends ContentCategory {
    def value: String = "IAB14-3"
  }

  case object `IAB14-4` extends ContentCategory {
    def value: String = "IAB14-4"
  }

  case object `IAB14-5` extends ContentCategory {
    def value: String = "IAB14-5"
  }

  case object `IAB14-6` extends ContentCategory {
    def value: String = "IAB14-6"
  }

  case object `IAB14-7` extends ContentCategory {
    def value: String = "IAB14-7"
  }

  case object `IAB14-8` extends ContentCategory {
    def value: String = "IAB14-8"
  }

  case object `IAB15` extends ContentCategory {
    def value: String = "IAB15"
  }

  case object `IAB15-1` extends ContentCategory {
    def value: String = "IAB15-1"
  }

  case object `IAB15-2` extends ContentCategory {
    def value: String = "IAB15-2"
  }

  case object `IAB15-3` extends ContentCategory {
    def value: String = "IAB15-3"
  }

  case object `IAB15-4` extends ContentCategory {
    def value: String = "IAB15-4"
  }

  case object `IAB15-5` extends ContentCategory {
    def value: String = "IAB15-5"
  }

  case object `IAB15-6` extends ContentCategory {
    def value: String = "IAB15-6"
  }

  case object `IAB15-7` extends ContentCategory {
    def value: String = "IAB15-7"
  }

  case object `IAB15-8` extends ContentCategory {
    def value: String = "IAB15-8"
  }

  case object `IAB15-9` extends ContentCategory {
    def value: String = "IAB15-9"
  }

  case object `IAB15-10` extends ContentCategory {
    def value: String = "IAB15-10"
  }

  case object `IAB16` extends ContentCategory {
    def value: String = "IAB16"
  }

  case object `IAB16-1` extends ContentCategory {
    def value: String = "IAB16-1"
  }

  case object `IAB16-2` extends ContentCategory {
    def value: String = "IAB16-2"
  }

  case object `IAB16-3` extends ContentCategory {
    def value: String = "IAB16-3"
  }

  case object `IAB16-4` extends ContentCategory {
    def value: String = "IAB16-4"
  }

  case object `IAB16-5` extends ContentCategory {
    def value: String = "IAB16-5"
  }

  case object `IAB16-6` extends ContentCategory {
    def value: String = "IAB16-6"
  }

  case object `IAB16-7` extends ContentCategory {
    def value: String = "IAB16-7"
  }

  case object `IAB17` extends ContentCategory {
    def value: String = "IAB17"
  }

  case object `IAB17-1` extends ContentCategory {
    def value: String = "IAB17-1"
  }

  case object `IAB17-2` extends ContentCategory {
    def value: String = "IAB17-2"
  }

  case object `IAB17-3` extends ContentCategory {
    def value: String = "IAB17-3"
  }

  case object `IAB17-4` extends ContentCategory {
    def value: String = "IAB17-4"
  }

  case object `IAB17-5` extends ContentCategory {
    def value: String = "IAB17-5"
  }

  case object `IAB17-6` extends ContentCategory {
    def value: String = "IAB17-6"
  }

  case object `IAB17-7` extends ContentCategory {
    def value: String = "IAB17-7"
  }

  case object `IAB17-8` extends ContentCategory {
    def value: String = "IAB17-8"
  }

  case object `IAB17-9` extends ContentCategory {
    def value: String = "IAB17-9"
  }

  case object `IAB17-10` extends ContentCategory {
    def value: String = "IAB17-10"
  }

  case object `IAB17-11` extends ContentCategory {
    def value: String = "IAB17-11"
  }

  case object `IAB17-12` extends ContentCategory {
    def value: String = "IAB17-12"
  }

  case object `IAB17-13` extends ContentCategory {
    def value: String = "IAB17-13"
  }

  case object `IAB17-14` extends ContentCategory {
    def value: String = "IAB17-14"
  }

  case object `IAB17-15` extends ContentCategory {
    def value: String = "IAB17-15"
  }

  case object `IAB17-16` extends ContentCategory {
    def value: String = "IAB17-16"
  }

  case object `IAB17-17` extends ContentCategory {
    def value: String = "IAB17-17"
  }

  case object `IAB17-18` extends ContentCategory {
    def value: String = "IAB17-18"
  }

  case object `IAB17-19` extends ContentCategory {
    def value: String = "IAB17-19"
  }

  case object `IAB17-20` extends ContentCategory {
    def value: String = "IAB17-20"
  }

  case object `IAB17-21` extends ContentCategory {
    def value: String = "IAB17-21"
  }

  case object `IAB17-22` extends ContentCategory {
    def value: String = "IAB17-22"
  }

  case object `IAB17-23` extends ContentCategory {
    def value: String = "IAB17-23"
  }

  case object `IAB17-24` extends ContentCategory {
    def value: String = "IAB17-24"
  }

  case object `IAB17-25` extends ContentCategory {
    def value: String = "IAB17-25"
  }

  case object `IAB17-26` extends ContentCategory {
    def value: String = "IAB17-26"
  }

  case object `IAB17-27` extends ContentCategory {
    def value: String = "IAB17-27"
  }

  case object `IAB17-28` extends ContentCategory {
    def value: String = "IAB17-28"
  }

  case object `IAB17-29` extends ContentCategory {
    def value: String = "IAB17-29"
  }

  case object `IAB17-30` extends ContentCategory {
    def value: String = "IAB17-30"
  }

  case object `IAB17-31` extends ContentCategory {
    def value: String = "IAB17-31"
  }

  case object `IAB17-32` extends ContentCategory {
    def value: String = "IAB17-32"
  }

  case object `IAB17-33` extends ContentCategory {
    def value: String = "IAB17-33"
  }

  case object `IAB17-34` extends ContentCategory {
    def value: String = "IAB17-34"
  }

  case object `IAB17-35` extends ContentCategory {
    def value: String = "IAB17-35"
  }

  case object `IAB17-36` extends ContentCategory {
    def value: String = "IAB17-36"
  }

  case object `IAB17-37` extends ContentCategory {
    def value: String = "IAB17-37"
  }

  case object `IAB17-38` extends ContentCategory {
    def value: String = "IAB17-38"
  }

  case object `IAB17-39` extends ContentCategory {
    def value: String = "IAB17-39"
  }

  case object `IAB17-40` extends ContentCategory {
    def value: String = "IAB17-40"
  }

  case object `IAB17-41` extends ContentCategory {
    def value: String = "IAB17-41"
  }

  case object `IAB17-42` extends ContentCategory {
    def value: String = "IAB17-42"
  }

  case object `IAB17-43` extends ContentCategory {
    def value: String = "IAB17-43"
  }

  case object `IAB17-44` extends ContentCategory {
    def value: String = "IAB17-44"
  }

  case object `IAB18` extends ContentCategory {
    def value: String = "IAB18"
  }

  case object `IAB18-1` extends ContentCategory {
    def value: String = "IAB18-1"
  }

  case object `IAB18-2` extends ContentCategory {
    def value: String = "IAB18-2"
  }

  case object `IAB18-3` extends ContentCategory {
    def value: String = "IAB18-3"
  }

  case object `IAB18-4` extends ContentCategory {
    def value: String = "IAB18-4"
  }

  case object `IAB18-5` extends ContentCategory {
    def value: String = "IAB18-5"
  }

  case object `IAB18-6` extends ContentCategory {
    def value: String = "IAB18-6"
  }

  case object `IAB19` extends ContentCategory {
    def value: String = "IAB19"
  }

  case object `IAB19-1` extends ContentCategory {
    def value: String = "IAB19-1"
  }

  case object `IAB19-2` extends ContentCategory {
    def value: String = "IAB19-2"
  }

  case object `IAB19-3` extends ContentCategory {
    def value: String = "IAB19-3"
  }

  case object `IAB19-4` extends ContentCategory {
    def value: String = "IAB19-4"
  }

  case object `IAB19-5` extends ContentCategory {
    def value: String = "IAB19-5"
  }

  case object `IAB19-6` extends ContentCategory {
    def value: String = "IAB19-6"
  }

  case object `IAB19-7` extends ContentCategory {
    def value: String = "IAB19-7"
  }

  case object `IAB19-8` extends ContentCategory {
    def value: String = "IAB19-8"
  }

  case object `IAB19-9` extends ContentCategory {
    def value: String = "IAB19-9"
  }

  case object `IAB19-10` extends ContentCategory {
    def value: String = "IAB19-10"
  }

  case object `IAB19-11` extends ContentCategory {
    def value: String = "IAB19-11"
  }

  case object `IAB19-12` extends ContentCategory {
    def value: String = "IAB19-12"
  }

  case object `IAB19-13` extends ContentCategory {
    def value: String = "IAB19-13"
  }

  case object `IAB19-14` extends ContentCategory {
    def value: String = "IAB19-14"
  }

  case object `IAB19-15` extends ContentCategory {
    def value: String = "IAB19-15"
  }

  case object `IAB19-16` extends ContentCategory {
    def value: String = "IAB19-16"
  }

  case object `IAB19-17` extends ContentCategory {
    def value: String = "IAB19-17"
  }

  case object `IAB19-18` extends ContentCategory {
    def value: String = "IAB19-18"
  }

  case object `IAB19-19` extends ContentCategory {
    def value: String = "IAB19-19"
  }

  case object `IAB19-20` extends ContentCategory {
    def value: String = "IAB19-20"
  }

  case object `IAB19-21` extends ContentCategory {
    def value: String = "IAB19-21"
  }

  case object `IAB19-22` extends ContentCategory {
    def value: String = "IAB19-22"
  }

  case object `IAB19-23` extends ContentCategory {
    def value: String = "IAB19-23"
  }

  case object `IAB19-24` extends ContentCategory {
    def value: String = "IAB19-24"
  }

  case object `IAB19-25` extends ContentCategory {
    def value: String = "IAB19-25"
  }

  case object `IAB19-26` extends ContentCategory {
    def value: String = "IAB19-26"
  }

  case object `IAB19-27` extends ContentCategory {
    def value: String = "IAB19-27"
  }

  case object `IAB19-28` extends ContentCategory {
    def value: String = "IAB19-28"
  }

  case object `IAB19-29` extends ContentCategory {
    def value: String = "IAB19-29"
  }

  case object `IAB19-30` extends ContentCategory {
    def value: String = "IAB19-30"
  }

  case object `IAB19-31` extends ContentCategory {
    def value: String = "IAB19-31"
  }

  case object `IAB19-32` extends ContentCategory {
    def value: String = "IAB19-32"
  }

  case object `IAB19-33` extends ContentCategory {
    def value: String = "IAB19-33"
  }

  case object `IAB19-34` extends ContentCategory {
    def value: String = "IAB19-34"
  }

  case object `IAB19-35` extends ContentCategory {
    def value: String = "IAB19-35"
  }

  case object `IAB19-36` extends ContentCategory {
    def value: String = "IAB19-36"
  }

  case object `IAB20` extends ContentCategory {
    def value: String = "IAB20"
  }

  case object `IAB20-1` extends ContentCategory {
    def value: String = "IAB20-1"
  }

  case object `IAB20-2` extends ContentCategory {
    def value: String = "IAB20-2"
  }

  case object `IAB20-3` extends ContentCategory {
    def value: String = "IAB20-3"
  }

  case object `IAB20-4` extends ContentCategory {
    def value: String = "IAB20-4"
  }

  case object `IAB20-5` extends ContentCategory {
    def value: String = "IAB20-5"
  }

  case object `IAB20-6` extends ContentCategory {
    def value: String = "IAB20-6"
  }

  case object `IAB20-7` extends ContentCategory {
    def value: String = "IAB20-7"
  }

  case object `IAB20-8` extends ContentCategory {
    def value: String = "IAB20-8"
  }

  case object `IAB20-9` extends ContentCategory {
    def value: String = "IAB20-9"
  }

  case object `IAB20-10` extends ContentCategory {
    def value: String = "IAB20-10"
  }

  case object `IAB20-11` extends ContentCategory {
    def value: String = "IAB20-11"
  }

  case object `IAB20-12` extends ContentCategory {
    def value: String = "IAB20-12"
  }

  case object `IAB20-13` extends ContentCategory {
    def value: String = "IAB20-13"
  }

  case object `IAB20-14` extends ContentCategory {
    def value: String = "IAB20-14"
  }

  case object `IAB20-15` extends ContentCategory {
    def value: String = "IAB20-15"
  }

  case object `IAB20-16` extends ContentCategory {
    def value: String = "IAB20-16"
  }

  case object `IAB20-17` extends ContentCategory {
    def value: String = "IAB20-17"
  }

  case object `IAB20-18` extends ContentCategory {
    def value: String = "IAB20-18"
  }

  case object `IAB20-19` extends ContentCategory {
    def value: String = "IAB20-19"
  }

  case object `IAB20-20` extends ContentCategory {
    def value: String = "IAB20-20"
  }

  case object `IAB20-21` extends ContentCategory {
    def value: String = "IAB20-21"
  }

  case object `IAB20-22` extends ContentCategory {
    def value: String = "IAB20-22"
  }

  case object `IAB20-23` extends ContentCategory {
    def value: String = "IAB20-23"
  }

  case object `IAB20-24` extends ContentCategory {
    def value: String = "IAB20-24"
  }

  case object `IAB20-25` extends ContentCategory {
    def value: String = "IAB20-25"
  }

  case object `IAB20-26` extends ContentCategory {
    def value: String = "IAB20-26"
  }

  case object `IAB20-27` extends ContentCategory {
    def value: String = "IAB20-27"
  }

  case object `IAB21` extends ContentCategory {
    def value: String = "IAB21"
  }

  case object `IAB21-1` extends ContentCategory {
    def value: String = "IAB21-1"
  }

  case object `IAB21-2` extends ContentCategory {
    def value: String = "IAB21-2"
  }

  case object `IAB21-3` extends ContentCategory {
    def value: String = "IAB21-3"
  }

  case object `IAB22` extends ContentCategory {
    def value: String = "IAB22"
  }

  case object `IAB22-1` extends ContentCategory {
    def value: String = "IAB22-1"
  }

  case object `IAB22-2` extends ContentCategory {
    def value: String = "IAB22-2"
  }

  case object `IAB22-3` extends ContentCategory {
    def value: String = "IAB22-3"
  }

  case object `IAB22-4` extends ContentCategory {
    def value: String = "IAB22-4"
  }

  case object `IAB23` extends ContentCategory {
    def value: String = "IAB23"
  }

  case object `IAB23-1` extends ContentCategory {
    def value: String = "IAB23-1"
  }

  case object `IAB23-2` extends ContentCategory {
    def value: String = "IAB23-2"
  }

  case object `IAB23-3` extends ContentCategory {
    def value: String = "IAB23-3"
  }

  case object `IAB23-4` extends ContentCategory {
    def value: String = "IAB23-4"
  }

  case object `IAB23-5` extends ContentCategory {
    def value: String = "IAB23-5"
  }

  case object `IAB23-6` extends ContentCategory {
    def value: String = "IAB23-6"
  }

  case object `IAB23-7` extends ContentCategory {
    def value: String = "IAB23-7"
  }

  case object `IAB23-8` extends ContentCategory {
    def value: String = "IAB23-8"
  }

  case object `IAB23-9` extends ContentCategory {
    def value: String = "IAB23-9"
  }

  case object `IAB23-10` extends ContentCategory {
    def value: String = "IAB23-10"
  }

  case object `IAB24` extends ContentCategory {
    def value: String = "IAB24"
  }

  case object `IAB25` extends ContentCategory {
    def value: String = "IAB25"
  }

  case object `IAB25-1` extends ContentCategory {
    def value: String = "IAB25-1"
  }

  case object `IAB25-2` extends ContentCategory {
    def value: String = "IAB25-2"
  }

  case object `IAB25-3` extends ContentCategory {
    def value: String = "IAB25-3"
  }

  case object `IAB25-4` extends ContentCategory {
    def value: String = "IAB25-4"
  }

  case object `IAB25-5` extends ContentCategory {
    def value: String = "IAB25-5"
  }

  case object `IAB25-6` extends ContentCategory {
    def value: String = "IAB25-6"
  }

  case object `IAB25-7` extends ContentCategory {
    def value: String = "IAB25-7"
  }

  case object `IAB26` extends ContentCategory {
    def value: String = "IAB26"
  }

  case object `IAB26-1` extends ContentCategory {
    def value: String = "IAB26-1"
  }

  case object `IAB26-2` extends ContentCategory {
    def value: String = "IAB26-2"
  }

  case object `IAB26-3` extends ContentCategory {
    def value: String = "IAB26-3"
  }

  case object `IAB26-4` extends ContentCategory {
    def value: String = "IAB26-4"
  }

}
