#### 기존 netflix-zuul gateway 서버를 사용하지 않고, Spring Cloud Gateway를 사용하는 이유
- Spring Cloud Gateway는 Netfilx Zuul보다 빠르고, 가볍다.
- Spring Cloud Gateway는 Netfilx Zuul보다 Netty와 Reactor를 사용하여 더 적은 쓰레드로 더 높은 성능을 낸다. (비동기)


#### 필터 순서
![img.png](img.png)


#### Eureka Server 를 기동시킨다면
- 각 Instance 들을 랜덤포트로 여러 개 띄울 때, 각 인스턴스들에 라운드로빈 방식으로 로드밸런싱이 가능함.
  - API Gateway -> Eureka server -> Eureka client(micro service) -> Service
  - Eureka Server 는 등록된 Instance 들의 정보를 캐싱해 효율적으로 처리.
- 각 Instance 들의 기동 상태를 확인 가능함.
- 다만 Spring Cloud 에서 자체적으로 Eureka Client 들의 Instance 개수를 자동으로 오토스케일링 하는 기능은 없음
  - 오토 스케일링은 AWS 또는 Kubernetes 등의 클라우드 플랫폼에서 지원하는 기능을 사용해야 함.

