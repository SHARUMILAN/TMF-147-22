#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

pthread_t* philosophers;
pthread_mutex_t* chopsticks;

pthread_cond_t* start_line;
pthread_mutex_t* chair;

int* done;

int N, T;
float L, M;

enum State {
    THINKING, HUNGRY, EATING
};

enum State* states;
int thinkcount = 0;
int hungrycount = 0;
int eatcount = 0;

pthread_mutex_t mutexthink;
pthread_mutex_t mutexhungry;
pthread_mutex_t mutexeat;

void* func(int n) {
    for (int i = 0; i < T; i++) {
        int ret = pthread_cond_wait(&start_line[n], &chair[n]);
        float random = 1;
        if (ret != 0) {
            printf("Error wait: %d", n);
            exit(1);
        }

        pthread_mutex_lock(&mutexthink);
        while (random > L) {
            random = (double)rand() / (double)RAND_MAX ;
            thinkcount++;
        }
        pthread_mutex_unlock(&mutexthink);

        pthread_mutex_lock(&chopsticks[n]);
        pthread_mutex_lock(&chopsticks[(n + 1) % N]);

        pthread_mutex_lock(&mutexhungry);
        random = 1;
        hungrycount++;
        pthread_mutex_unlock(&mutexhungry);

        pthread_mutex_unlock(&chopsticks[n]);
        pthread_mutex_unlock(&chopsticks[(n + 1) % N]);

        pthread_mutex_lock(&mutexeat);
        random = 1;
        while (random > M) {
            random = (double)rand() / (double)RAND_MAX ;
            eatcount++;
        }
        pthread_mutex_unlock(&mutexeat);

        done[n] = 1;
    }

    return (NULL);
}

int main(int argc, char *argv[])
{
    int opt;

    N = 5;
    T = 100;
    L = 0.1;
    M = 0.2;

    // put ':' in the starting of the
    // string so that program can
    //distinguish between '?' and ':'
    while((opt = getopt(argc, argv, ":iM:iN:iT:iL:lrx")) != -1)
    {
        switch(opt)
        {
            case 'N':
                N = atoi(optarg);
                printf("N: %d\n", N);
                break;
            case 'T':
                T = atoi(optarg);
                printf("T: %d\n", T);
                break;
            case 'L':
                L = atof(optarg);
                printf("L: %f\n", L);
                break;
            case 'M':
                M = atof(optarg);
                printf("M: %f\n", M);
                break;
            case '?':
                printf("unknown option: %c\n", optopt);
                break;
        }
    }

    if (N < 1 || T < 1 || L < 0 || M < 0) {
        printf("\nYour arguments are wrong! Please check them again!\n\n");
        return -1;
    }

    philosophers = malloc(N * sizeof(pthread_t));
    chopsticks = malloc(N * sizeof(pthread_mutex_t));
    chair = malloc(N * sizeof(pthread_mutex_t));
    done = malloc(N * sizeof(int));
    start_line = malloc(N * sizeof(pthread_cond_t));

    for (int i = 0; i < N; i++) {
        pthread_mutex_init(&chopsticks[i], NULL);
        pthread_mutex_init(&chair[i], NULL);
        pthread_cond_init(&start_line[i], NULL);
        pthread_mutex_lock(&chair[i]);
        done[i] = 0;
    }

    pthread_mutex_init(&mutexthink, NULL);
    pthread_mutex_init(&mutexeat, NULL);
    pthread_mutex_init(&mutexhungry, NULL);

    for (int i = 0; i < N; i++) {
        pthread_create(&philosophers[i], NULL, (void *)func, (void *)i);
    }

    for (int i = 0; i < T; i++) {
        usleep(100);
        for (int j = 0; j < N; j++) {
            pthread_mutex_unlock(&chair[j]);
            int ret = pthread_cond_signal(&start_line[j]);
            if (ret != 0) {
                printf("Error Signal %d", j);
                exit(1);
            }
            printf("%d-%d all signaled\n", i, j);
        }


        while (1) {
            int doneAll = 1;
            for (int j = 0; j < N; j++)
                if (done[j] == 0) {
                    doneAll = 0;
                    break;
                }
            if (doneAll)
                break;
        }

        usleep(100);
        for (int j = 0; j < N; j++) {
            done[j] = 0;
        }
    }

    for (int i = 0; i < N; i++) {
        pthread_join(philosophers[i], NULL);
    }

    for (int i = 0; i < N; i++) {
        pthread_mutex_destroy(&chopsticks[i]);
        pthread_mutex_destroy(&chair[i]);
        pthread_cond_destroy(&start_line[i]);
    }

    pthread_mutex_destroy(&mutexthink);
    pthread_mutex_destroy(&mutexeat);
    pthread_mutex_destroy(&mutexhungry);

    free(philosophers);
    free(start_line);
    free(chair);
    free(chopsticks);
    free(done);

    printf("Average Thinking Time: %6.2f\n", (double)thinkcount / T / N);
    printf("Average Hungry Time: %6.2f\n", (double)hungrycount / T / N);
    printf("Average Eating Time: %6.2f\n", (double)eatcount / T / N);

    return 0;
}
