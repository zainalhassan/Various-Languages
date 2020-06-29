class ArithmeticTaskRunner
{
    constructor()
    {
        this.tasks = [];
    }

    get taskCount()
    {
        return this.tasks.length;
    }

    addNegationTask = () => {
        this.tasks.push( function (x) {return -x });
    };
    addAdditionTask = y => {
        this.tasks.push( function (x) {return x + y });
    };

    addMultiplicationTask = y => {
        this.tasks.push( function (x) {return  x * y });
    };

    execute = (startValue = 0) => {
        for (let i in this.tasks) {
            startValue = this.tasks[i](startValue);
        }
        return startValue;
    };
}

print = console.log;

taskRunner = new ArithmeticTaskRunner();

taskRunner.addAdditionTask(10);
taskRunner.addNegationTask();
taskRunner.addMultiplicationTask(0.5);

print(taskRunner.execute());
print(taskRunner.execute(10));
print(taskRunner.taskCount);

taskRunner = new ArithmeticTaskRunner();
taskRunner.addAdditionTask(2);
taskRunner.addMultiplicationTask(4);
taskRunner.addAdditionTask(10);

print(taskRunner.execute(2));
print(taskRunner.execute(-2));

taskRunner = new ArithmeticTaskRunner();
taskRunner.addAdditionTask(2);
taskRunner.taskCount = 5;

print(taskRunner.taskCount);