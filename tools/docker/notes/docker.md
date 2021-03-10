# Docker

Table of Contents
-----------------

* [1. Container](#1-container)
* [2. Components](#2-components)
   * [2.1 Container](#21-container)
   * [2.2 Image](#22-image)
   * [2.3 Repository](#23-repository)
* [References](#references)


## 1. Container

> Containers are an ecapsulation of an application w/ its dependencies

**VMs**

<div align="center"> <img src="image-20210306115401756.png" width="50%"/> </div><br>

Unlike VMs, **the host's kernel is shared w/ running containers**, which means processes running inside containers are equivalent to native process

**Containers**

<div align="center"> <img src="image-20210306115859080.png" width="50%"/> </div><br>

**Docker and Containers**

Docker took the existing Linux container tech and wrapped and extended it



## 2. Components

**Overview**

<div align="center"> <img src="docker-overview.svg" width="50%"/> </div><br>

### 2.1 Container

A container is simply another process on your machine that has been isolated from all other processes on the host machine

### 2.2 Image

<div align="center"> <img src="image.png" width="60%"/> </div><br>

- filesystem
- all dependencies, configuration, scripts, binaries, etc
- configuration for the container

### 2.3 Repository

**Docker Hub**

<div align="center"> <img src="docker-hub.png" width="40%"/> </div><br>


## References

- *Docker in Action*
- *Using Docker*
- [Install Docker Engine on CentOS](https://docs.docker.com/engine/install/centos/)
