#!/usr/bin/env bash
# Auto-traffic generator for the JobSearch demo app (Option A — "dynamic" data).
# Periodically exercises normal + error endpoints so fresh OTEL logs/traces keep
# flowing into OpenSearch (log-analytics-logrite / trace-analytics-raw-logrite),
# without anyone hitting URLs by hand. Cortex then always has recent errors to
# surface + offer Fix-it on. Safe to remove: delete the crontab line + this file.
set -u
BASE="http://localhost:9081"

# Bail quietly if the app isn't up (e.g. between deploys/reboots).
curl -sS -o /dev/null --max-time 8 "$BASE/" || exit 0

# Normal traffic — populates logs + traces with successful queries.
for term in spring java python react devops kubernetes terraform aws; do
  curl -sS -o /dev/null --max-time 10 "$BASE/jobs/search?term=$term"
done
curl -sS -o /dev/null --max-time 10 "$BASE/jobs"
curl -sS -o /dev/null --max-time 10 "$BASE/employers"
curl -sS -o /dev/null --max-time 10 "$BASE/candidates/search?term=engineer"

# Creation traffic — DISABLED 2026-05-30 (user request). The auto-creates below
# were inflating "how many <X> created today" (≈39 demo jobs/day vs real user
# activity), making Cortex's accurate count look wrong. Search + error traffic
# below is kept so Cortex Fix-it / error demos still get a fresh stream. To
# re-enable a steady, countable creation stream for "how many created" demos,
# uncomment this block.
#
# TS="$(date -u +%H%M%S)"
# for i in 1 2 3; do
#   curl -sS -o /dev/null --max-time 10 -X POST "$BASE/jobs" -H 'Content-Type: application/json' \
#     -d "{\"title\":\"Auto Role ${TS}-${i}\",\"description\":\"auto-generated demo job\",\"companyName\":\"DemoCo\",\"city\":\"Remote\",\"state\":\"CA\",\"country\":\"US\",\"skills\":\"java\",\"salary\":\"120000\",\"salaryCurrency\":\"USD\",\"contactEmail\":\"auto${TS}${i}@demo.io\"}"
# done
# for i in 1 2; do
#   curl -sS -o /dev/null --max-time 10 -X POST "$BASE/candidates" -H 'Content-Type: application/json' \
#     -d "{\"firstName\":\"Auto${TS}${i}\",\"lastName\":\"Demo\",\"email\":\"cand${TS}${i}@demo.io\",\"skills\":\"python\",\"city\":\"NYC\"}"
# done
# curl -sS -o /dev/null --max-time 10 -X POST "$BASE/employers" -H 'Content-Type: application/json' \
#   -d "{\"name\":\"AutoEmp${TS}\",\"companyName\":\"DemoCorp\",\"email\":\"emp${TS}@demo.io\",\"city\":\"SF\"}"

# Error traffic — keeps a fresh, varied set of SEVERE/exception logs in the
# recent window (Arithmetic, NumberFormat, NullPointer, IndexOutOfBounds,
# ClassCast), each tracing to a real class/method for the Fix-it levels.
for ep in candidates/simulate-error jobs/simulate-error employers/simulate-error \
          proposals/simulate-error jobs/simulate-search-error; do
  curl -sS -o /dev/null --max-time 12 "$BASE/$ep"
done

echo "$(date -u +%FT%TZ) generate-traffic: ok"
