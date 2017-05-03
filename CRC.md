2016-05-20 18:53:19 AGB

# Responsibilities

  * store activities
  * generate statement from activities
    * reverse activities' order
  * calculate the partial balances
  * format statement:
    * header
    * rows: amount, date, partial balance
  * print statement

# CRC cards

## Account
### R
  * deposit, withdrawal
  * print statement

  * knows activities storage
  * knows statement printing
  * knows the meaning of activities' types: withdrawal, deposit. Creation

  * pattern: Façade ? Idea of orchestration (only in printing)
  * stereotype: Interfacer

### C
  * Activities
  * Printer


## Activities
### R 
  * stores activities
  * knows how to create a statement

  * stereotype: information holder
  * pattern: repository

### C
  * StatementFactory

## StatementFactory
### R 
  * translate from Activities to  Statement

  * pattern: factory (the most general)
  * stereotype: Service Provider

### C
  * Clock

## Statement
### R
  * knows how to print itself

  * pattern: value object, aggregation of others
  * stereotype: Structurer

### C
  * Printer

## Format
### R
  * knows how to format a statement (header and rows)
	  * este es el caso que le pongo "knows" aunque lo haga directamente, para ver cómo queda

  * service: service provide
  * pattern: strategy

### C
  * Nil

## Printer
### R
  * Prints statement lines

### C
  * Format
