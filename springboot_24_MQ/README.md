# JMS  javaMessageServer


AMQP
AMQP (advanced message queuing protocol):一种协议（高级消息队列协议，也是消息代理规范)，规范了网络交换的数据格式，兼容JMS
优点:具有跨平台性，服务器供应商，生产者，消费者可以使用不同的语言来实现AMQP消息模型
direct exchangefanout exchangetopic exchangeheaders exchangesystem exchange
种类：byte[]


## activeMQ

下载：<a href="https://activemq.apache.org/components/classic/download">activeMQ</a>

启动服务，需要找到安装解压路径》》win64》》双击（请注意activemq所需java版本和本机安装的java版本是否对应）
> activemq.bat

访问服务器
> http://localhost:8161/

服务端口：61616，管理后台端口：8161
用户名&密码：admin


## RabbitMQ

erlang
下载：https://www.erlang.org/downloads
安装：按照提示默认安装，重启操作系统
环境变量配置：ERLANG_HOME:xxx；PATH:%ERLANG_HOME%\bin

1. 电脑名称为中文

2. erlang和rabbitmq版本不匹配

3. 安装目录有空格或中文


https://www.rabbitmq.com/which-erlang.html
https://github.com/rabbitmq/rabbitmq-server/releases?q=3.10&expanded=true

rabbitmq
https://www.rabbitmq.com/download.html

启动rabbitmq
```
C:\WINDOWS\system32>d:

D:\>cd D:\Program Files (x86)\Java\RabbitMQ Server\rabbitmq_server-3.10.10\sbin

D:\Program Files (x86)\Java\RabbitMQ Server\rabbitmq_server-3.10.10\sbin>rabbitmq-service.bat start
```

已安装，不能启动 2022年11月4日12:49:52



## rocketmq
2022年11月5日21:50:38
已安装，不能启动
https://dlcdn.apache.org/rocketmq/5.0.0/rocketmq-all-5.0.0-bin-release.zip
下载解压，默认服务端口9876，配置环境变量：ROCKETMQ_HOME,PATH,NAMESRV_ADDR:127.0.0.1:9876


## kafka
https://archive.apache.org/dist/kafka/2.8.0/kafka_2.12-2.8.0.tgz

启动
D:\Program Files (x86)\Java\kafka2.8.1\bin\windows>zookeeper-server-start.bat ../../config/zookeeper.properties
D:\Program Files (x86)\Java\kafka2.8.1\bin\windows>kafka-server-start.bat ../../config/server.properties