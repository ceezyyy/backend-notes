# Git

<div align="center"> <img src="logo.png" width="50%"/> </div><br>



Table of Contents
-----------------

* [Overview](#overview)
* [1. 什么是 Git?](#1-什么是-git)
* [2. Git 分区](#2-git-分区)
* [3. Git branch](#3-git-branch)
* [References](#references)



## Overview

`git` 的学习遵循 “二八原则” ，即 20% 的命令能满足日常开发过程中 80% 的需求

本文参考 `labuladong` 大神的 "我用四个命令概括了 Git 的所有套路" 文章，针对 `add`，`commit`，`reset` 以及 `checkout` 四个命令进行剖析




## 1. 什么是 Git?

维基百科

> git 是一个分布式版本控制软件，最初由林纳斯·托瓦兹创作，于 2005 年以 GPL 发布。最初目的是为更好地管理 Linux 内核开发而设计。



## 2. Git 分区

`git` 分为三个区：

- work dir：工作目录，肉眼能见到的文件
- stage：从 `work dir` 使用 `git add` 命令后，文件就提交到了此暂存区
- history：从暂存区使用 `git commit` 提交后，文件就到了此区，即 `HEAD` 指向的位置



<div align="center"> <img src="areas.png" width="50%"/> </div><br>





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



## References

- [Git教程 - 廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/896043488029600)
- [您必须知道的 Git 分支开发规范](https://juejin.im/post/6844903635533594632)
- [我用四个命令概括了 Git 的所有套路](https://labuladong.gitbook.io/algo/di-wu-zhang-ji-shu-wen-zhang-xi-lie/git-chang-yong-ming-ling)