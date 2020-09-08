# Git

<div align="center"> <img src="logo.png" width="50%"/> </div><br>

Table of Contents
-----------------

* [1. 什么是 git?](#1-什么是-git)
* [2. Git workflow](#2-git-workflow)
* [3. Git branch](#3-git-branch)
* [参考链接](#参考链接)




## 1. 什么是 git?

维基百科

> git 是一个分布式版本控制软件，最初由林纳斯·托瓦兹创作，于 2005 年以 GPL 发布。最初目的是为更好地管理 Linux 内核开发而设计。



## 2. Git workflow

<div align="center"> <img src="workflow.png" width="60%"/> </div><br>

- remote：远程仓库
- repository：本地仓库 / 版本库
- index：暂存区
- workspace：工作区（本地）



## 3. Git branch

<div align="center"> <img src="branch.png" width="50%"/> </div><br>

在企业级开发时，常见的分支类型有以下几种：

- master 
- develop 
- feature 
- release 
- hotfix



**master 分支**

- 主分支
- 部署生产环境
- 一般由 `develop` 以及 `hotfix` 分支合并，任何时间都不能直接修改代码



**develop 分支**

- 开发分支
- 始终保持最新完成以及 `bug` 修复后的代码
- 所有 `feature` 分支都是基于 `develop` 分支下创建的



**feature 分支**
- 个人开发分支
- 以 `develop` 分支为基础创建 `feature` 分支



**release 分支**

- 预上线分支
- 发布提测阶段





**hotfix 分支**

- 紧急修复分支
- 修复完成后，需合并到 `master` 分支和 `develop` 分支



## 参考链接

- [Git教程 - 廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/896043488029600)
- [您必须知道的 Git 分支开发规范](https://juejin.im/post/6844903635533594632)