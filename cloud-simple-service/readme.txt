系统相关：
-------------------------------------------
开发环境 编码：UTF-8							
开发环境 工具：myeclipse 10
开发环境 SVN：site-1.8.22
开发环境 注释插件：jautodoc_1.8.0
开发环境 Web服务器：Tomcat7
开发环境 JDK: 1.7
开发环境 Maven 3

数据库访问：mybatis3.3 
MVC：spring MVC 4.2.4

工程文件夹命名规范，参照spring：
spring-boot-autoconfigure
spring-boot-sample-jpa

包及文件夹命名方式：
com.ebt.系统简写.分层.业务模块.业务模块...
例如：
com.ebt.p2p.dao
com.ebt.p2p.dao.invest.user

com.ebt.insurance.dao
com.ebt.insurance.dao.product.manager

数据表命名方式：
系统简写_业务模块_业务模块_业务模块...

jsp、htlm等静态文件命名方式（小写）：
实体-子实体-操作。jsp
product-detail-list.jsp
product-detail-edit.jsp

数据表、类、包命名方式：尽量少用单词简写要用全称

接口：
spring mvc restful接口
客户端使用restTemplate访问
服务器端返回结果采用ResponseEntity
