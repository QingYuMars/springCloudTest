地址：https://www.cnblogs.com/xiaostudy/p/12729611.html

在此基础上集成了gateway，config和common

集成config时遇到的问题：
    1.https://blog.csdn.net/galoiszhou/article/details/115010058?utm_medium=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-1.nonecase&depth_1-utm_source=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-1.nonecase
![img.png](img.png)
    2.目前尚未解决，配置中心启动后，web和server读取配置中心的地址是IP地址，而不是localhost
