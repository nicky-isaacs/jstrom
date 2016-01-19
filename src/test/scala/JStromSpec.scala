import com.example.JStrom
import org.scalatest._
import play.api.libs.json.Json

class JStromSpec extends FlatSpec with Matchers {

  "JStrom" should "work for the base case" in {

    val testString = "{\"ip\": \"8.8.8.8\"}"

    JStrom(testString.toStream).parse.head shouldEqual Json.parse(testString)
  }

  "JStrom" should "parse this thing" in {
    val theThing = """
      |[
      |  {
      |    "_id": "569dbc8839ba3c24c2b8b9d9",
      |    "index": 0,
      |    "guid": "e3224947-eced-4dfa-b3db-3d07fd5612a3",
      |    "isActive": false,
      |    "balance": "$3,696.00",
      |    "picture": "http://placehold.it/32x32",
      |    "age": 34,
      |    "eyeColor": "brown",
      |    "name": {
      |      "first": "Cannon",
      |      "last": "Mccray"
      |    },
      |    "company": "CIPROMOX",
      |    "email": "cannon.mccray@cipromox.biz",
      |    "phone": "+1 (915) 429-3257",
      |    "address": "431 Randolph Street, Norwood, Michigan, 1225",
      |    "about": "Duis anim cillum ullamco enim cupidatat laborum reprehenderit adipisicing reprehenderit adipisicing voluptate. Nisi esse duis incididunt qui ea fugiat mollit Lorem. Aliqua occaecat laboris ipsum amet. Ipsum eiusmod cupidatat tempor consectetur culpa.",
      |    "registered": "Thursday, February 19, 2015 7:40 PM",
      |    "latitude": "-79.243956",
      |    "longitude": "-10.382699",
      |    "tags": [
      |      7,
      |      "sit"
      |    ],
      |    "range": [
      |      0,
      |      1,
      |      2,
      |      3,
      |      4,
      |      5,
      |      6,
      |      7,
      |      8,
      |      9
      |    ],
      |    "friends": [
      |      3,
      |      {
      |        "id": 1,
      |        "name": "Shanna Olsen"
      |      }
      |    ],
      |    "greeting": "Hello, Cannon! You have 7 unread messages.",
      |    "favoriteFruit": "strawberry"
      |  },
      |  {
      |    "_id": "569dbc88a151a38e48624508",
      |    "index": 1,
      |    "guid": "b8e694c9-99f3-4c2e-af35-5732af440cb5",
      |    "isActive": true,
      |    "balance": "$1,376.41",
      |    "picture": "http://placehold.it/32x32",
      |    "age": 39,
      |    "eyeColor": "blue",
      |    "name": {
      |      "first": "Washington",
      |      "last": "Blevins"
      |    },
      |    "company": "KROG",
      |    "email": "washington.blevins@krog.io",
      |    "phone": "+1 (852) 575-2890",
      |    "address": "759 Vanderbilt Avenue, Inkerman, Maryland, 1030",
      |    "about": "Id occaecat cupidatat sunt excepteur do amet Lorem sit pariatur dolor excepteur nulla amet. Anim pariatur Lorem excepteur ea ipsum ad nisi in reprehenderit mollit aliquip ipsum ipsum. Irure proident cillum officia enim et ea et. Duis qui incididunt ex incididunt reprehenderit et officia. Excepteur deserunt esse deserunt ipsum nulla labore eiusmod adipisicing do quis id dolor ipsum duis.",
      |    "registered": "Tuesday, March 18, 2014 9:20 PM",
      |    "latitude": "-43.370885",
      |    "longitude": "-12.580738",
      |    "tags": [
      |      7,
      |      "sit"
      |    ],
      |    "range": [
      |      0,
      |      1,
      |      2,
      |      3,
      |      4,
      |      5,
      |      6,
      |      7,
      |      8,
      |      9
      |    ],
      |    "friends": [
      |      3,
      |      {
      |        "id": 1,
      |        "name": "Shanna Olsen"
      |      }
      |    ],
      |    "greeting": "Hello, Washington! You have 10 unread messages.",
      |    "favoriteFruit": "apple"
      |  },
      |  {
      |    "_id": "569dbc89a64821c281de0125",
      |    "index": 2,
      |    "guid": "37380ca9-5dfe-4ea7-8ee2-d90187dd311b",
      |    "isActive": true,
      |    "balance": "$1,333.49",
      |    "picture": "http://placehold.it/32x32",
      |    "age": 34,
      |    "eyeColor": "brown",
      |    "name": {
      |      "first": "Olson",
      |      "last": "Drake"
      |    },
      |    "company": "CENTICE",
      |    "email": "olson.drake@centice.ca",
      |    "phone": "+1 (974) 529-2821",
      |    "address": "820 Brooklyn Avenue, Tetherow, Tennessee, 1215",
      |    "about": "Irure minim sint consequat fugiat enim incididunt in ut ex duis nisi mollit. Exercitation cupidatat duis excepteur non excepteur ullamco laborum proident ea duis incididunt. Exercitation qui consectetur proident voluptate et pariatur. Labore occaecat cupidatat cupidatat est ad adipisicing sint aute exercitation quis in pariatur nostrud magna. Dolore et sunt amet duis et. Sit excepteur eiusmod eiusmod deserunt nisi magna magna reprehenderit et aliqua sit occaecat. Nisi duis amet irure et esse.",
      |    "registered": "Friday, January 3, 2014 8:42 PM",
      |    "latitude": "67.871224",
      |    "longitude": "-154.703429",
      |    "tags": [
      |      7,
      |      "sit"
      |    ],
      |    "range": [
      |      0,
      |      1,
      |      2,
      |      3,
      |      4,
      |      5,
      |      6,
      |      7,
      |      8,
      |      9
      |    ],
      |    "friends": [
      |      3,
      |      {
      |        "id": 1,
      |        "name": "Shanna Olsen"
      |      }
      |    ],
      |    "greeting": "Hello, Olson! You have 6 unread messages.",
      |    "favoriteFruit": "banana"
      |  },
      |  {
      |    "_id": "569dbc89941ba2cfd270149d",
      |    "index": 3,
      |    "guid": "39740a7e-ac0b-4449-bd66-37dfb4dcfd34",
      |    "isActive": true,
      |    "balance": "$2,056.83",
      |    "picture": "http://placehold.it/32x32",
      |    "age": 33,
      |    "eyeColor": "brown",
      |    "name": {
      |      "first": "Sharlene",
      |      "last": "Townsend"
      |    },
      |    "company": "SNOWPOKE",
      |    "email": "sharlene.townsend@snowpoke.tv",
      |    "phone": "+1 (819) 523-3757",
      |    "address": "924 Troy Avenue, Longbranch, Pennsylvania, 9590",
      |    "about": "Id duis reprehenderit nostrud voluptate reprehenderit et occaecat. Id Lorem est non ea nisi in ad incididunt. Qui culpa Lorem Lorem ut. Do adipisicing amet laborum non voluptate. Ullamco incididunt fugiat do sunt aute laborum aliquip dolore reprehenderit in sit. In aute deserunt aliqua aute nisi commodo elit.",
      |    "registered": "Monday, July 13, 2015 6:12 AM",
      |    "latitude": "-34.02873",
      |    "longitude": "127.667814",
      |    "tags": [
      |      7,
      |      "sit"
      |    ],
      |    "range": [
      |      0,
      |      1,
      |      2,
      |      3,
      |      4,
      |      5,
      |      6,
      |      7,
      |      8,
      |      9
      |    ],
      |    "friends": [
      |      3,
      |      {
      |        "id": 1,
      |        "name": "Shanna Olsen"
      |      }
      |    ],
      |    "greeting": "Hello, Sharlene! You have 9 unread messages.",
      |    "favoriteFruit": "strawberry"
      |  },
      |  {
      |    "_id": "569dbc89d9f1efb1d664d248",
      |    "index": 4,
      |    "guid": "a79d65b8-e6cb-4e21-9389-dfda97497185",
      |    "isActive": true,
      |    "balance": "$3,220.06",
      |    "picture": "http://placehold.it/32x32",
      |    "age": 20,
      |    "eyeColor": "blue",
      |    "name": {
      |      "first": "Karin",
      |      "last": "Henry"
      |    },
      |    "company": "ZENSOR",
      |    "email": "karin.henry@zensor.net",
      |    "phone": "+1 (965) 504-2679",
      |    "address": "565 Cedar Street, Stonybrook, Missouri, 4579",
      |    "about": "In nulla elit enim minim sit non fugiat nulla et et id exercitation voluptate voluptate. Voluptate minim laborum Lorem amet consequat ex excepteur mollit ut velit aute. Aliquip consectetur ex non nisi dolor sit id aliqua Lorem incididunt velit deserunt duis. Commodo officia eiusmod ipsum non tempor dolor velit officia qui. Sint aute et laboris duis in dolor ad pariatur. Velit esse excepteur ex sint dolor veniam magna ad. Fugiat do minim nisi dolor consectetur cupidatat eiusmod tempor.",
      |    "registered": "Sunday, January 11, 2015 10:07 PM",
      |    "latitude": "-84.956951",
      |    "longitude": "76.393092",
      |    "tags": [
      |      7,
      |      "sit"
      |    ],
      |    "range": [
      |      0,
      |      1,
      |      2,
      |      3,
      |      4,
      |      5,
      |      6,
      |      7,
      |      8,
      |      9
      |    ],
      |    "friends": [
      |      3,
      |      {
      |        "id": 1,
      |        "name": "Shanna Olsen"
      |      }
      |    ],
      |    "greeting": "Hello, Karin! You have 8 unread messages.",
      |    "favoriteFruit": "banana"
      |  }
      |]
    """.stripMargin

    JStrom(theThing.toStream).parse.head shouldEqual Json.parse(theThing)
  }

}
