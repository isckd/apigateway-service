#### 기존 netflix-zuul gateway 서버를 사용하지 않고, Spring Cloud Gateway를 사용하는 이유

- Spring Cloud Gateway는 Netfilx Zuul보다 빠르고, 가볍다.
- Spring Cloud Gateway는 Netfilx Zuul보다 Netty와 Reactor를 사용하여 더 적은 쓰레드로 더 높은 성능을 낸다. (비동기)