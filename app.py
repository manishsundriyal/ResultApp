from flask import Flask, request, jsonify
from decouple import config
import csv

app = Flask(__name__)

@app.route('/')
def index():
	return 'Welcome to GGSIPU result API'

@app.route('/getResult', methods = ['POST'])
def getResult():
	key = request.form['api-key']
	if key == config('KEY'):
		resp = list()
		with open('result.csv', 'r') as f:
			reader = csv.reader(f)
			for row in reader:
				enroll, name, something = row[:3]
				res = row[3:]
				resp.append({
					'enrollment_number' : enroll,
					'name' : name,
					'something' : something,
					'results' : res
				})
		return jsonify(resp)
	else:
		resp = {
			'error' : 'Invalid Key'	
		}
		return jsonify(resp)

@app.route('/getResultViaEnroll', methods = ['POST'])
def getResultViaEnroll():
	key = request.form['api-key']
	if key == config('KEY'):
		enrollpost = request.form['enrollment-number']
		with open('result.csv', 'r') as f:
			reader = csv.reader(f)
			for row in reader:
				enroll, name, something = row[:3]
				res = row[3:]
				if enroll == enrollpost:
					resp = {
						'enrollment_number' : enroll,
						'name' : name,
						'something' : something,
						'results' : res
					}
					return jsonify(resp)
		resp = {
			'error' : 'Enrollment Number not Found !'
		}
		return jsonify(resp)
	else:
		resp = {
			'error' : 'Invalid Key'
		}
		return jsonify(resp)

if __name__ == '__main__':
	app.run(port=8080, debug = True)
