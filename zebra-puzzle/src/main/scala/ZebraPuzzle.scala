import scala.collection.mutable.ListBuffer

object ZebraPuzzle {

  sealed trait Resident
  case object Englishman extends Resident
  case object Spaniard extends Resident
  case object Ukrainian extends Resident
  case object Norwegian extends Resident
  case object Japanese extends Resident

  case class House(order: Int,
                  nationality: Resident,
                  color: String,
                  drink: String,
                  smoke: String,
                  pet: String)

  case class Solution(waterDrinker: Resident, zebraOwner: Resident)

  lazy val solve: Solution = {
    ???
  }
}

/*
5 채의 집이 있습니다.
영국 사람은 빨간집에 산다.
스페인 사람은 개를 키운다.
녹색집 사람은 커피를 마신다.
우크라이나 사람은 차를 마신다.
녹색집은 흰색 집 바로 오른쪽에 있다.
OldGold를 피는 사람은 달팽이를 키운다.
Kools는 노란 집에서 핀다.
가운데 사는 사람은 우유를 마신다.
노르웨이 사람은 첫 번째 집에 산다.
Chesterfields를 피우는 남자는 여우를 키우는 사람에 옆 집에서 산다.
Kools를 피는 사람은 말을 키우는 사람 옆 집에 산다.
Lucky Strike를 피는 사람은 오렌지 주스를 마신다.
일본인은 Parliaments를 핀다.
노르웨이 사람은 파란집 옆에 산다.

질문: 물을 마시는 사람은 누구? 얼룩말을 키우는 사람은 누구?
(전제: 모든 집은 다른 속성을 가지고 있다.)

-----------------------------------------
순서	  국가		    색		    음료  	  담배	    팻
1		  노르웨이	  노란색		    	  Kools
2					      파란색		                말
3							          우유


					      흰색
					      녹색    	커피

      영국		    빨간색
 */

