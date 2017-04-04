import scala.collection.mutable.ListBuffer

object ZebraPuzzle {

  sealed trait Color
  case object Red extends Color
  case object Blue extends Color
  case object Green extends Color
  case object Yellow extends Color
  case object Ivory extends Color

  sealed trait Resident
  case object Englishman extends Resident
  case object Spaniard extends Resident
  case object Ukrainian extends Resident
  case object Norwegian extends Resident
  case object Japanese extends Resident

  sealed trait Drink
  case object Tea extends Drink
  case object Milk extends Drink
  case object Coffee extends Drink
  case object OrangeJuice extends Drink
  case object Water extends Drink

  sealed trait Smoke
  case object Kools extends Color
  case object LuckyStrike extends Color
  case object Chesterfields extends Color
  case object OldGold extends Color
  case object Parliamanets extends Color

  sealed trait Pet
  case object Dog extends Pet
  case object Fox extends Pet
  case object Horse extends Pet
  case object Snails extends Pet
  case object Zebra extends Pet

  case class Fact(order: Option[Int] = None,
                 color: Option[Color] = None,
                 resident: Option[Resident] = None,
                 drink: Option[Drink] = None,
                 smoke: Option[Smoke] = None,
                 pet: Option[Pet] = None)

  case class Solution(waterDrinker: Resident, zebraOwner: Resident)

  lazy val solve: Solution = {
    ???
  }
}

/*
import ZebraPuzzle._

import scala.util.{Failure, Success}

val houses = List(
  Fact(order = Some(1)),
  Fact(order = Some(2)),
  Fact(order = Some(3)),
  Fact(order = Some(4)),
  Fact(order = Some(5)))

val fact02: Fact = Fact(color = Some(Red), resident = Some(Englishman))

val fact03: Fact = Fact(resident = Some(Spaniard), pet = Some(Dog))

def tryCombine(l: Option[Any], r: Option[Any]) =
  if (l.isDefined && r.isDefined && l != r) Failure
  else Success((l ++ r).headOption)

val zs = fact02.productIterator.zip(fact03.productIterator).toList

for ((l:Option[Any], r: Option[Any]) <- zs) {
  println(s"$l, $r")
  println(tryCombine(l, r))
}

for { (l:Option[Any], r: Option[Any]) <- zs
  isSuccess = tryCombine(l, r)
} yield isSuccess


houses.updated(0, houses(0).copy(order = Some(2)))
 */

/*
이 수수께끼는 5 개의 다른 색깔의 주택으로 구성되어 있으며 각기 다른 국적의 거주자가 살고 있습니다.
각 거주자는 다른 애완 동물을 소유하고 다른 음료를 선호하며 다른 담배보다 다른 브랜드의 담배를 피 웁니다.

1. 5 채의 집이 있습니다.
2. 영국 사람은 빨간집에 산다.
3. 스페인 사람은 개를 키운다.
4. 녹색집 사람은 커피를 마신다.
5. 우크라이나 사람은 차를 마신다.
6. 녹색집은 흰색 집 바로 오른쪽에 있다.
7. Oldgold를 피는 사람은 달팽이를 키운다.
8. Kools는 노란 집에서 핀다.
9. 가운데 사는 사람은 우유를 마신다.
10. 노르웨이 사람은 첫 번째 집에 산다.
11. Chesterfields를 피우는 남자는 여우를 키우는 사람에 옆 집에서 산다.
12. Kools를 피는 사람은 말을 키우는 사람 옆 집에 산다.
13. Lucky Strike를 피는 사람은 오렌지 주스를 마신다.
14. 일본인은 Parliamanets를 핀다.
15. 노르웨이 사람은 파란집 옆에 산다.

1. [ House(None, None, None, None, None, None)
     House(None, None, None, None, None, None)
     House(None, None, None, None, None, None)
     House(None, None, None, None, None, None)
     House(None, None, None, None, None, None) ]

2. House(None, Englishman, Red, None, None, None)
3. House(None, Spaniard, None, None, None, Dog)
4. House(None, None, Green, Coffee, None, None)
5. House(None, Ukrainian, None, Tea, None, None)
6. [ House(None, None, White, None, None)
     House(None, None, Green, None, None) ]
...

질문: 물을 마시는 사람은 누구? 얼룩말을 키우는 사람은 누구?
(전제: 모든 집은 다른 속성을 가지고 있다.)

(http://waitbutwhy.com/table/zebra-puzzle)

-----------------------------------------
순서	  국가		    색		    음료  	  담배    팻
1		  노르웨이	  노란색		    	  Kools
2					      파란색		                말
3							          우유
4
5


?					      흰색
?					      녹색    	커피

?     영국		    빨간색

?     스페인                             개

?     우크라이나         차

?                               Oldgold  달팽이
 */

/*
var xs = ListBuffer(
  (None, Some(Englishman), None, None, None, None, None),
  (None, Some(Spaniard), None, None, None, None, None),
  (None, Some(Ukrainian), None, None, None, None, None),
  (None, Some(Norwegian), None, None, None, None, None),
  (None, Some(Japanese), None, None, None, None, None) )

xs(0).productArity
xs(0).productIterator.toList

 */