# spring-boot-github-actions-example
[![Build](https://github.com/Mark1708/spring-boot-github-actions-example/actions/workflows/build.yml/badge.svg)](https://github.com/Mark1708/spring-boot-github-actions-example/actions/workflows/build.yml)
[![Deploy docker image](https://github.com/Mark1708/spring-boot-github-actions-example/actions/workflows/deploy.yml/badge.svg)](https://github.com/Mark1708/spring-boot-github-actions-example/actions/workflows/deploy.yml)
<br/>

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Mark1708_spring-boot-github-actions-example&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Mark1708_spring-boot-github-actions-example)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Mark1708_spring-boot-github-actions-example&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Mark1708_spring-boot-github-actions-example)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Mark1708_spring-boot-github-actions-example&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Mark1708_spring-boot-github-actions-example)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Mark1708_spring-boot-github-actions-example&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=Mark1708_spring-boot-github-actions-example)
<br/>

![GitHub Actions](https://img.shields.io/badge/-githubactions-0a0a0a?style=for-the-badge&logo=githubactions) 
![Spring Boot](https://img.shields.io/badge/-springboot-0a0a0a?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/-postgresql-0a0a0a?style=for-the-badge&logo=postgresql)
![Flyway](https://img.shields.io/badge/-flyway-0a0a0a?style=for-the-badge&logo=flyway)
![Docker](https://img.shields.io/badge/-Docker-0a0a0a?style=for-the-badge&logo=Docker)
<br/>

> Пример настройки Github Actions для Spring Boot приложения

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
В этом проекте я пробовал прелести использования Github Actions в личных проектах
Использовалось 2 ветки main и dev. При pull request в main запускаются экшены, которые проводят тестирование и генерирует отчеты о покрываемости и тд. Также после проверки реквесту присваевается соответсвующий лейбл в случае если он не указан конкретно. Затем изображение загружается в DockerHub.

Автоматизизация запуска тестов + построение отчета в [codecov.io](https://codecov.io/)
<br/>
Статический анализ в [sonarcloud.io](https://sonarcloud.io/)
<br/>

## Technologies
* Java - version 11
* Spring Boot - version 2.7.2
* PostgreSQL
* Flyway
* Docker
* Github Actions

## Status
Проект _закончен_

## Inspiration
Проект сделан в образовательных целях

## Contact
Created by [Gurianov Mark](https://mark1708.github.io/) - feel free to contact me!
#### +7(962)024-50-04 | mark1708.work@gmail.com | [github](http://github.com/Mark1708)

![Readme Card](https://github-readme-stats.vercel.app/api/pin/?username=mark1708&repo=spring-boot-github-actions-example&theme=chartreuse-dark&show_icons=true)
