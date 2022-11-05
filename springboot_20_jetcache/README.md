#  jetcache 缓存整合（alibaba）  2022年11月1日22:48:16
jetCache对SpringCache进行了封装，在原有功能基础上实现了多级缓存、缓存统计、自动刷新、异步调用、数据报表等功能
jetCache设定了本地缓存与远程缓存的多级缓存解决方案：
本地缓存( local)
LinkedHashMap
caffeine
远程缓存（ remote)
Redis
Tair