import json
import numpy

def get_list_for(index, attribute):
    evaluations = []
    for rec in data:
        evaluations.append(int(rec[index][attribute]))
    return evaluations

def get_list_of_averages_for(attribute):
    averages = []
    for i in range(1, 13):
        averages.append(average_value_for(str(i), attribute))
    return averages


def average_value_for(index, attribute):
    sum = 0
    for rec in data:
        sum = sum + int(rec[index][attribute])
    return sum / len(data)

def diff_of_averages_for(index, attribute):
    return average_value_for(index, attribute) - average_value_for(str(int(index) + 1), attribute)


def get_averages_for_all(attribute):
    averages = []
    for i in range(1, len(data)):
        averages.append(average_value_for(str(i), attribute))
    return averages
    

def print_averages_for_general(attribute):
    for i in ['english', 'german', 'accent']:
        print(average_value_for(i, attribute))

def print_diff_of_averages_for_all(attribute):
    for i in range(1, len(data) + 1, 2):
        print(diff_of_averages_for(str(i), attribute))

def print_diff_for_general(attribute):
    print(average_value_for('english', attribute) - average_value_for('german', attribute))

res = open('/Users/janschnegotzki/research/results/formatted/all_results.json')
data = json.load(res)
res.close()


