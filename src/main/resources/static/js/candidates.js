const logger = console;
var cndtsDataTable;
var cndtReviewMap = new Map();
var cndtMsgMap = new Map();

function loadCndtsTable() {
logger.debug('>>> Entering loadCndtsTable()');


/*
    jobsDataTable = $('#jobsTable').DataTable(
        {
            "processing": true, // for show progress bar
            "aaData": "data",
            "ajax": {
                url: '/jobs',
                dataType: 'json',
                type: 'get',
                dataSrc: '',
                headers: {
                    'XSRF-TOKEN': $('input:hidden[name="__RequestVerificationToken"]').val(),
                },
                beforeSend: function (xhr) {
				logger.debug(`>>> Entering beforeSend(xhr=${xhr})`);
               //     $("#pageloader").show();
				logger.debug(`<<< Exiting beforeSend(xhr=${xhr})`);
                },
                complete: function (xhr) {
					logger.debug(`>>> Entering complete(xhr=${xhr})`);
                    
                 //   $("#pageloader").hide();
				logger.debug(`<<< Exiting complete(xhr=${xhr})`);
                },
            },
            "paging": true,
            "filter": true, // this is for disable filter (search box)
            "orderMulti": false, // for disable multiple column at once
            "columns": [
                { data: "jobId" },
                { data: "title" },
                { data: "description" },
                { data: "updatedOn" },
            ],
            "columnDefs": [
                {
                    "targets": [0],
                    "visible": false,
                    "searchable": false
                },
                
            ],
            
            "responsive": true
        }
    );
*/
	
	$.ajax({
	    'url': "/candidates",
	    'method': "GET",
	    'contentType': 'application/json'
	}).done( function(data) {
		
		//console.log(data);
		data.forEach(d => {
			console.log(d);
			cndtReviewMap[d.candidateId] = d.reviews;
			cndtMsgMap[d.candidateId] = d.messages;
			d.reviews.forEach(p => {
				console.log(p);
			});
		});
		/*data.forEach(d => {
			d.proposals.forEach(p => {
				jobProposalMap[p.jobId] = p;
			});
		}*/
		
	    $('#cndtsTable').dataTable( {
	    	"processing": true, // for show progress bar
	    	"paging": true,
	    	"responsive": true,
	        "aaData": data,
	        "columns": [
                { data: "candidateId" },
                { data: "name" },
                { data: "email" },
                { data: "skills" },
                {
                    data: "reviewCount",
                    "render": function (data, type, row) {
						logger.debug(`>>> Entering function(data=${data},type=${type},row=${row})`);
						logger.debug(`<<< Exiting function(data=${data},type=${type},row=${row})`);
                        return '<a href="#" onclick="showReviews(\'' + row.candidateId + '\');">' + data + '</a>';
                    }
                },
                {
                    data: "messageCount",
                    "render": function (data, type, row) {
                        return '<a href="#" onclick="showMessages(\'' + row.candidateId + '\');">' + data + '</a>';
                    }
                }               
	        ]
	    })
	})

logger.debug('<<< Exiting loadCndtsTable()');
}

function initRater(stars)
{
	logger.debug(`>>> Entering initRater(stars=${stars})`);
	$(".rating").rate();

	//or for example
	var options = {
	    max_value: 5,
	    step_size: 0.5,
	    initial_value: stars
	}
	$(".rating").rate(options);
	logger.debug(`<<< Exiting initRater(stars=${stars})`);
}

function showReviews(cndtId)
{
	var reviews = cndtReviewMap[cndtId];
	var overallRating = 0;
	
	for (i = 0; i < reviews.length; i++)
	{
		overallRating += reviews[i].stars;
	}
	overallRating = overallRating / reviews.length;
	
	var overallDiv = '<div class="rating" data-rate-value='+overallRating+'></div>'+overallRating.toFixed(1)+' / 5';
	$(".modal-body").append(overallDiv);
	
	reviews.forEach(r => {
		logger.debug(`>>> Entering showReviews(cndtId=${cndtId})`);
		
		var div = '<p><div class="rating" data-rate-value='+r.stars+'></div><div class="form-group"><textarea class="form-control" id="exampleFormControlTextarea1" rows="3">' + r.comments + '</textarea><p align="right">' + r.reviewFrom + '</p></div></p>';
		$(".modal-body").append(div);
		logger.debug(`<<< Exiting showReviews(cndtId=${cndtId})`);
		initRater(r.stars);
	});
	
    
    $("#reviewsModal").show();//.modal('show');
	
}

function showMessages(cndtId)
{
	var messages = cndtMsgMap[cndtId];
	
	
	messages.forEach(m => {
		logger.debug(`>>> Entering showMessages(cndtId=${cndtId})`);
		
		var div = '<div class="form-group"><textarea class="form-control" id="exampleFormControlTextarea1" rows="3">' + m.message + '</textarea><p align="right">' + m.postedBy + '</p></div>';
		logger.debug(`<<< Exiting showMessages(cndtId=${cndtId})`);
		$(".modal-body").append(div);
	});
	
	var div = '<div class="form-group"><textarea class="form-control" id="msgBox" rows="3"></textarea><button id="sendMsg" type="button" class="btn btn-primary">Send</button></div>';
	$(".modal-body").append(div);
	
    $("#msgModal").show();//.modal('show');	
    bindEvents();
}

function bindEvents()
{
	$(document).on("click", "#sendMsg", function() {
		logger.debug(`>>> Entering on(document=${document})`);
		//append code here
		logger.debug('>>> Entering bindEvents()');
		alert("click");
		logger.debug('<<< Exiting bindEvents()');
		});
	
}