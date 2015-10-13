#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define FILE_NAME "../randgen/random.txt"

void bubbleSort(int* x, int n)
{
    int i, j, tmp;

    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n - i; j++)
        {
            if (x[j] > x[j+1])
            {
                tmp = x[j];
                x[j] = x[j+1];
                x[j+1] = tmp;
            }
        }
    }
}

int isSorted(int* x, int n)
{
    int i;

    for (i = 0; i < n - 1; i++)
    {
        if (x[i] > x[i+1])
            return 0;
    }
    return 1;
}

int main()
{
    int i, n;
    int* x;
    FILE* fp;
    clock_t start, end;

    fp = fopen(FILE_NAME, "r");
    if (fp == NULL)
    {
        printf("ファイルが見つかりません。\n");
        exit(EXIT_FAILURE);
    }

    fscanf(fp, "%d", &n);
    x = (int*) malloc(n * sizeof(int));

    for (i = 0; i < n; i++)
    {
        fscanf(fp, "%d", x+i);
    }

    fclose(fp);

    printf("test: %d\n", n);

    start = clock();
    bubbleSort(x, n);
    end = clock();
    if (!isSorted(x, n))
    {
        printf("Sort error.\n");
        exit(EXIT_FAILURE);
    }

    printf("経過時間 %dms\n", (end - start));

    free(x);

    return EXIT_SUCCESS;
}
