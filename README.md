# Organisational-API

* By Roselyne Moraa

## Description

This is an applicatins that allow users/rangers to input the different animals that are sighted to be recorded.

## Setup/Installation Requirements

* Install Java JRE (Runtime Environment).
* Install Postgres.
* Install Gradle.
* Clone this repository onto your desktop. This will place the all files and folders in onto your computer.
* Start Postgres in an additional terminal tab by entering postgres.
* In yet another terminal window start psql with psql.
* In psql tab enter CREATE DATABASE org_api;.
* In terminal tab enter psql wildlife_tracker < wildlife_tracker.sql.
* In psql tab enter \c wildlife_tracker then \dt.
* In terminal tab enter gradle run.

## Program Behaviour

Rangers can add their names so that they can be identified.
Ranger adds a zone where the sighting was made.
Ranger adds the name of the animal they sighted.
Ranger adds the suspected age of the animal.
Ranger adds the suspected health of the animal.
Ranger adds species of the animal whether endangered or not endangered
A timestamp is created by the database to record time of sighting

## Technologies

*Junit
*Java
*Spark
*postgres

## Known Bugs

No bugs so far.if found,email me at elijahroselyne@gmail.com

## License
MIT License

Copyright (c) 2019 Rosellyne

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.