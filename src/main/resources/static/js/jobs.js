const logger = console;
var jobsDataTable;
var jobProposalMap = new Map();

function loadJobsTable() {
logger.debug('>>> Entering loadJobsTable()');
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
	    'url': "/jobs/contacts/ab@gmail.com",
	    'method': "GET",
	    'contentType': 'application/json'
	}).done( function(data) {
		
		logger.info(`loadJobsTable()=null): SOC2-AUDIT [CC6.6]: Database transaction completed`);
		//console.log(data);
		data.forEach(d => {
			console.log(d);
			jobProposalMap[d.jobId] = d.proposals;
			d.proposals.forEach(p => {
				console.log(p);
			});
		});
		/*data.forEach(d => {
			d.proposals.forEach(p => {
				jobProposalMap[p.jobId] = p;
			});
		}*/
		
	    $('#jobsTable').dataTable( {
	    	"processing": true, // for show progress bar
	    	"paging": true,
	    	"responsive": true,
	        "aaData": data,
	        "columns": [
                { data: "jobId" },
                { data: "title" },
                { data: "description" },
                { data: "updatedOn" },
                {
                    data: "proposalCount",
                    "render": function (data, type, row) {
                        return '<a href="#" onclick="showProposals(\'' + row.jobId + '\');">' + data + '</a>';
                    }
                }
	        ]
	    })
	})

logger.debug('<<< Exiting loadJobsTable()');
}

function showProposals(jobId)
{
    $('#proposalsTable').dataTable( {
    	"processing": true, // for show progress bar
    	"paging": true,
    	"responsive": true,
        "aaData": jobProposalMap[jobId],
        "columns": [
            { data: "proposalId" },
            { data: "bidPrice" },
            { data: "estimatedTime" },
            { data: "contactEmail" },
            { data: "contactPhone" }
        ]
    })
    
    $("#proposalsModal").show();//.modal('show');
	
}