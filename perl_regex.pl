#!/usr/bin/perl

use strict;
use warnings;

my $t = time;

open(my $f, "<./results.csv") or die("no hay archivo");

my $match = 0;
my $nomatch = 0;

while(<$f>) {

    chomp; # omite saltos de linea y otros caracteres
	# 2018-06-04,Italy,Netherlands,1,1,Friendly,Turin,Italy,FALSE
    # m --> match 
    # en pearl: /regex/
    if(m/^[\d]{4,4}\-02\-.*$/){
        printf $_."\n";
        $match++;
    } else{
        $nomatch++;
    }

}

close($f);

printf("Se encontraron \n - %d matches\n - %d no matches\ntardo %d segundos\n"
	, $match, $nomatch, time() - $t);