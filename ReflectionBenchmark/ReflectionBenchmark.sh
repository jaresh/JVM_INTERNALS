#!/bin/bash

DATE=`date +%Y-%m-%d:%H:%M`
TIMEFORMAT=%R

# ---------------------------------------
# ------- Benchmark configuration -------
# ---------------------------------------

TESTING_LOOP=5
ENABLE_SIMPLE=true
ENABLE_REFERENCE=true
ENABLE_METHOD=true

# ---------------------------------------

clear
echo "Testing Begin"
echo ""
echo "---Warmup---"

for i in {1..5};
do
   	java Warmup
done

echo "Warmup complete"
echo ""

if [ "$ENABLE_SIMPLE" = true ] ;
then

	touch "Results/"$DATE"-simple.csv"
	echo "Test name, Time" >> "Results/"$DATE"-simple.csv"
  	echo "---Simple test---"

	for i in $(seq 1 $TESTING_LOOP);
	do
	   echo -n "SimpleReadNoReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Simple SimpleReadNoReflection ; } 2>> "Results/"$DATE"-simple.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "SimpleReadReflection," >> "Results/"$DATE"-simple.csv"
	   	{ time java -classpath ./Simple SimpleReadReflection ; } 2>> "Results/"$DATE"-simple.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "SimpleWriteNoReflection," >> "Results/"$DATE"-simple.csv"
	   	{ time java -classpath ./Simple SimpleWriteNoReflection ; } 2>> "Results/"$DATE"-simple.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "SimpleWriteReflection," >> "Results/"$DATE"-simple.csv"
	   	{ time java -classpath ./Simple SimpleWriteReflection ; } 2>> "Results/"$DATE"-simple.csv"
	done

	echo "Simple test complete"
	echo ""
fi

if [ "$ENABLE_REFERENCE" = true ] ;
then
	touch "Results/"$DATE"-reference.csv"
	echo "Test name, Time" >> "Results/"$DATE"-reference.csv"
  	echo "---Reference test---"

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "ReferenceReadNoReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Reference ReferenceReadNoReflection ; } 2> "Results/"$DATE"-reference.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "ReferenceReadReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Reference ReferenceReadReflection ; } 2> "Results/"$DATE"-reference.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "ReferenceWriteNoReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Reference ReferenceWriteNoReflection ; } 2> "Results/"$DATE"-reference.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "ReferenceWriteReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Reference ReferenceWriteReflection ; } 2> "Results/"$DATE"-reference.csv"
	done

	echo "Reference test complete"
	echo ""
fi

if [ "$ENABLE_METHOD" = true ] ;
then

	touch "Results/"$DATE"-method.csv"
	echo "Test name, Time" >> "Results/"$DATE"-method.csv"
  	echo "---Method test---"

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "MethodNoReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Method MethodNoReflection ; } 2> "Results/"$DATE"-method.csv"
	done

	for i in $(seq 1 $TESTING_LOOP);
	do
		echo -n "MethodReflection," >> "Results/"$DATE"-simple.csv"
	   { time java -classpath ./Method MethodReflection ; } 2> "Results/"$DATE"-method.csv"
	done

	echo "Method test complete"
	echo ""
fi

echo "Testing complete, results in csv files."
echo ""