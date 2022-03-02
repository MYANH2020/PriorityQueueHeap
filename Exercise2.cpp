#include <iostream>
using namespace std;
int myMax(int * a, int size ) {
int max= a[0];
for(int i = 0; i< size; i++)
{
if(a[i]> max)
{
max = a[i];
}
}
return max;
}
double myAverage( int *a, int size)
{
double sum = 0.0;
for(int i = 0; i< size; i++)
{
sum += a[i];
}
double average = sum/size;
return average;
}
int *myCopy( int* a, int size)
{
int *b = new int[size];
for( int i = 0; i<size; i++)
{
b[i] = a[i];
}
return b;
}
void printNumbers( int * a, int size)
{
for(int i =0; i<size; i++)
{
cout << a[i] << endl;
}
}
void myReverse( int * a, int size)
{
for(int i = 0; i< size/2; i ++)
{
int temp = a[i] ;
a[i] = a[ size -i -1 ];
 a[ size -i -1 ]= temp  ;
}
}
bool isPrime( long int num)
{
if( num < 2) 
{
return false;
}
for( long int i = 2; i*i <= num; i++)
{
if(num %i == 0) 
{return false;
}
return true;
}
}
void printPrimeNumber( int *a, int size )
{
for(int i = 0; i < size; i++)
{

if (isPrime( a[i])){

cout << a[i] << endl;
}
}
}

int main ()
{
int numbers [] = { 10, 5, 15, 12};
int highest;
int lowest;
double avg;
highest = myMax( numbers, 4);
avg = myAverage( numbers, 4);
cout << " The highest number is " << highest<< endl;
cout << " The average number is " << avg<< endl;
int* outNumbers = myCopy(numbers, 4);
cout<<" the original array " << endl;
printNumbers( outNumbers,4);
myReverse( outNumbers, 4);
cout << "The reverse array is "<< endl;
printNumbers(outNumbers, 4);
cout<< " These are the prime number in the array "<< endl;
printPrimeNumber(outNumbers,4);
return 0;
}

