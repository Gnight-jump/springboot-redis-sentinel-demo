# Springboot整合redis哨兵模式

#### 介绍
Springboot整合redis哨兵模式：
包括了增删查改接口，采用mybatis，当数据从数据库查出来后会放入redis缓存。
采用的同步策略是：先更新数据库，后删除缓存。