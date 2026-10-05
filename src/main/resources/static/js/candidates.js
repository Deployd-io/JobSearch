var logger = (typeof logger !== 'undefined' && logger) || console;
var cndtsDataTable;
var cndtReviewMap = new Map();
var cndtMsgMap = new Map();

function loadCndtsTable() {
logger.info('>>> Entering loadCndtsTable()', { "event.action": "loadCndtsTable" });


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
               //     $("#pageloader").show();
                },
                complete: function (xhr) {
                    
                 //   $("#pageloader").hide();
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
						logger.info(`>>> Entering render(data=${data},type=${type},row=${row})`, { "event.action": "render", "logrite.data": data, "logrite.type": type, "logrite.row": row });
						logger.info(`<<< Exiting render(data=${data},type=${type},row=${row})`, { "event.action": "render", "logrite.data": data, "logrite.type": type, "logrite.row": row });
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

logger.info('<<< Exiting loadCndtsTable()', { "event.action": "loadCndtsTable" });
}

function initRater(stars)
{
	logger.info(`>>> Entering initRater(stars=${stars})`, { "event.action": "initRater", "logrite.stars": stars });
	$(".rating").rate();

	//or for example
	var options = {
	    max_value: 5,
	    step_size: 0.5,
	    initial_value: stars
	}
	$(".rating").rate(options);
	logger.info(`<<< Exiting initRater(stars=${stars})`, { "event.action": "initRater", "logrite.stars": stars });
}

function showReviews(cndtId)
{
	logger.info(`>>> Entering showReviews(cndtId=${cndtId})`, { "event.action": "showReviews", "logrite.cndtId": cndtId });
	var reviews = cndtReviewMap[cndtId];
	var overallRating = 0;
	
	for (i = 0; i < reviews.length; i++)
	{
		overallRating += reviews[i].stars;
	}
	overallRating = overallRating / reviews.length;
	
	var overallDiv = '<div class="rating" data-rate-value='+overallRating+'></div>'+overallRating.toFixed(1)+' / 5';
	logger.error(`showReviews(cndtId=${cndtId}): overallDiv → ${overallDiv}`, { "event.action": "showReviews", "logrite.cndtId": cndtId });
	$(".modal-body").append(overallDiv);
	
	reviews.forEach(r => {
		
		var div = '<p><div class="rating" data-rate-value='+r.stars+'></div><div class="form-group"><textarea class="form-control" id="exampleFormControlTextarea1" rows="3">' + r.comments + '</textarea><p align="right">' + r.reviewFrom + '</p></div></p>';
		logger.error(`showReviews(cndtId=${cndtId}): div → ${div}`, { "event.action": "showReviews", "logrite.cndtId": cndtId });
		$(".modal-body").append(div);
		initRater(r.stars);
	});
	
    
    $("#reviewsModal").show();//.modal('show');
	
	logger.info(`<<< Exiting showReviews(cndtId=${cndtId})`, { "event.action": "showReviews", "logrite.cndtId": cndtId });
}

function showMessages(cndtId)
{
	logger.info(`>>> Entering showMessages(cndtId=${cndtId})`, { "event.action": "showMessages", "logrite.cndtId": cndtId });
	var messages = cndtMsgMap[cndtId];
	
	
	messages.forEach(m => {
		
		var div = '<div class="form-group"><textarea class="form-control" id="exampleFormControlTextarea1" rows="3">' + m.message + '</textarea><p align="right">' + m.postedBy + '</p></div>';
		$(".modal-body").append(div);
	});
	
	var div = '<div class="form-group"><textarea class="form-control" id="msgBox" rows="3"></textarea><button id="sendMsg" type="button" class="btn btn-primary">Send</button></div>';
	logger.error(`showMessages(cndtId=${cndtId}): div → ${div}`, { "event.action": "showMessages", "logrite.cndtId": cndtId });
	$(".modal-body").append(div);
	
    $("#msgModal").show();//.modal('show');	
    bindEvents();
	logger.info(`<<< Exiting showMessages(cndtId=${cndtId})`, { "event.action": "showMessages", "logrite.cndtId": cndtId });
}

function bindEvents()
{
	logger.info('>>> Entering bindEvents()', { "event.action": "bindEvents" });
	$(document).on("click", "#sendMsg", function() {
		//append code here
		alert("click");
		});
	
	logger.info('<<< Exiting bindEvents()', { "event.action": "bindEvents" });
}