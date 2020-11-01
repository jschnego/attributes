import json

def average_value_for(index, attribute):
    sum = 0
    for rec in data:
        sum = sum + int(rec[index][attribute])
    return sum / len(data)

def diff_of_averages_for(index, attribute):
    return average_value_for(index, attribute) - average_value_for(str(int(index) + 1), attribute)


def print_averages_for_all(attribute):
    for i in range(1, len(data)):
        print(average_value_for(str(i), attribute))

def print_diff_of_averages_for_all(attribute):
    for i in range(1, len(data), 2):
        print(diff_of_averages_for(str(i), attribute))

def print_diff_for_general(attribute):
    print(average_value_for('english', attribute) - average_value_for('german', attribute))

res = open('/Users/janschnegotzki/research/results/formatted/all_results.json')
data = json.load(res)
res.close()


