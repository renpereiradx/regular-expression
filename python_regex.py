#!/usr/bin/python3
import re #Traemos las expresiones regulares

pattern = re.compile(r'^([\d]{4,4})\-\d\d-\d\d,(.+),(.+),(\d+),(\d+),.*$')

f = open("./results.csv", "r")

for line in f:
  res = re.match(pattern, line)
  if res:
    total = int(res.group(4)) + int(res.group(5))
    if total > 20:
      print(f"Goles: {total} - Fecha:{res.group(1)} | {res.group(2)} [{res.group(4)}] -{res.group(3)} [{res.group(5)}]")

f.close()