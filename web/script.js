let count = 0;
let fruits = [
    {
        name : 'watermelon',
        color : 'green'
    },
    {
        name : 'mango',
        color : 'yellow'
    },
    {
        name : 'orange',
        color : 'orange'
    },
    {
        name : 'banana',
        color : 'yellow'
    },
    {
        name : 'apple',
        color : 'red'
    }
];

function test(){
    document.getElementById('demo').innerHTML = fruits[count].name;
    count = count + 1;
}
