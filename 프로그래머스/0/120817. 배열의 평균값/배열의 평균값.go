func solution(numbers []int) float64 {
    sum := 0
    for _, number := range numbers {
        sum += number
    }
    return float64(sum) / float64(len(numbers))
}